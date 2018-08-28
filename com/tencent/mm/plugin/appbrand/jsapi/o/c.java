package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.jsapi.base.e;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.widget.b.a;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public static f bL(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new f(0, (float) iArr[0], (float) iArr[1]);
    }

    public static void a(ViewGroup viewGroup, MotionEvent motionEvent) {
        int pointerId;
        int childCount = viewGroup.getChildCount();
        int actionIndex = motionEvent.getActionIndex();
        if (viewGroup.isMotionEventSplittingEnabled()) {
            pointerId = 1 << motionEvent.getPointerId(actionIndex);
        } else {
            pointerId = -1;
        }
        for (int i = childCount - 1; i >= 0; i--) {
            View childAt = viewGroup.getChildAt(i);
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (a.bS(childAt) && a.a(viewGroup, x, y, childAt) && childAt.isDuplicateParentStateEnabled()) {
                if (childAt == null) {
                    x.v("MicroMsg.ViewMotionHelper", "child is null.");
                } else {
                    actionIndex = motionEvent.getAction();
                    if (actionIndex == 3) {
                        motionEvent.setAction(3);
                        childAt.dispatchTouchEvent(motionEvent);
                        motionEvent.setAction(actionIndex);
                    } else {
                        int intValue = ((Integer) j.a(MotionEvent.class, "getPointerIdBits", motionEvent, new Class[0], new Object[0], Integer.valueOf(0))).intValue();
                        int i2 = intValue & pointerId;
                        if (i2 == 0) {
                            x.v("MicroMsg.ViewMotionHelper", "newPointerIdBits is 0.");
                        } else {
                            MotionEvent obtain;
                            boolean booleanValue = ((Boolean) j.a(View.class, "hasIdentityMatrix", childAt, new Class[0], new Object[0], Boolean.valueOf(false))).booleanValue();
                            if (i2 != intValue) {
                                MotionEvent motionEvent2 = (MotionEvent) j.a(null, "split", motionEvent, new Class[]{Integer.class}, new Object[]{Integer.valueOf(i2)}, null);
                                obtain = motionEvent2 == null ? MotionEvent.obtain(motionEvent) : motionEvent2;
                            } else if (booleanValue) {
                                x = (float) (viewGroup.getScrollX() - childAt.getLeft());
                                y = (float) (viewGroup.getScrollY() - childAt.getTop());
                                motionEvent.offsetLocation(x, y);
                                childAt.dispatchTouchEvent(motionEvent);
                                motionEvent.offsetLocation(-x, -y);
                            } else {
                                obtain = MotionEvent.obtain(motionEvent);
                            }
                            obtain.offsetLocation((float) (viewGroup.getScrollX() - childAt.getLeft()), (float) (viewGroup.getScrollY() - childAt.getTop()));
                            if (!booleanValue) {
                                obtain.transform((Matrix) j.a(View.class, "getInverseMatrix", childAt, new Class[0], new Object[0], null));
                            }
                            childAt.dispatchTouchEvent(obtain);
                            obtain.recycle();
                        }
                    }
                }
                if ((childAt instanceof e) && ((e) childAt).ail()) {
                    return;
                }
            }
        }
    }
}
