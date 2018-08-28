package com.tencent.mm.plugin.appbrand.widget.b;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;
import android.view.View;
import android.view.ViewGroup;

public final class a {
    public static boolean bR(View view) {
        return view != null && (view instanceof d) && ((d) view).apd();
    }

    public static boolean bS(View view) {
        return view.getVisibility() == 0 || view.getAnimation() != null;
    }

    @TargetApi(11)
    public static boolean a(ViewGroup viewGroup, float f, float f2, View view) {
        float[] fArr = new float[]{0.0f, 0.0f};
        fArr[0] = ((float) (viewGroup.getScrollX() - view.getLeft())) + f;
        fArr[1] = ((float) (viewGroup.getScrollY() - view.getTop())) + f2;
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            matrix.invert(matrix);
            matrix.mapPoints(fArr);
        }
        return fArr[0] >= 0.0f && fArr[1] >= 0.0f && fArr[0] < ((float) (view.getRight() - view.getLeft())) && fArr[1] < ((float) (view.getBottom() - view.getTop()));
    }

    @TargetApi(11)
    public static boolean a(ViewGroup viewGroup, MotionEvent motionEvent, View view, int i) {
        if (viewGroup == null || motionEvent == null) {
            return false;
        }
        int action = motionEvent.getAction();
        boolean dispatchTouchEvent;
        if (action == 3) {
            motionEvent.setAction(3);
            if (view == null) {
                return false;
            }
            dispatchTouchEvent = view.dispatchTouchEvent(motionEvent);
            motionEvent.setAction(action);
            return dispatchTouchEvent;
        }
        int i2;
        action = 0;
        for (i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
            action |= 1 << motionEvent.getPointerId(i2);
        }
        int i3 = action & i;
        if (i3 == 0) {
            return false;
        }
        MotionEvent motionEvent2;
        if (i3 != action) {
            int pointerCount = motionEvent.getPointerCount();
            PointerProperties[] pointerPropertiesArr = new PointerProperties[pointerCount];
            PointerCoords[] pointerCoordsArr = new PointerCoords[pointerCount];
            int[] iArr = new int[pointerCount];
            int action2 = motionEvent.getAction();
            int i4 = action2 & 255;
            int i5 = (65280 & action2) >> 8;
            i2 = -1;
            int i6 = 0;
            for (action = 0; action < pointerCount; action++) {
                motionEvent.getPointerProperties(action, pointerPropertiesArr[i6]);
                if (((1 << pointerPropertiesArr[i6].id) & i3) != 0) {
                    if (action == i5) {
                        i2 = i6;
                    }
                    iArr[i6] = action;
                    i6++;
                }
            }
            if (i6 == 0) {
                throw new IllegalArgumentException("idBits did not match any ids in the event");
            }
            if (i4 == 5 || i4 == 6) {
                if (i2 < 0) {
                    action2 = 2;
                } else if (i6 == 1) {
                    action2 = i4 == 5 ? 0 : 1;
                } else {
                    action2 = i4 | (i2 << 8);
                }
            }
            MotionEvent motionEvent3 = null;
            int historySize = motionEvent.getHistorySize();
            int i7 = 0;
            while (i7 <= historySize) {
                action = i7 == historySize ? Integer.MIN_VALUE : i7;
                for (i3 = 0; i3 < i6; i3++) {
                    motionEvent.getHistoricalPointerCoords(iArr[i3], action, pointerCoordsArr[i3]);
                }
                long historicalEventTime = motionEvent.getHistoricalEventTime(action);
                if (i7 == 0) {
                    motionEvent3 = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), action2, i6, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
                    motionEvent3.offsetLocation(motionEvent3.getX() - motionEvent3.getRawX(), motionEvent3.getY() - motionEvent3.getRawY());
                } else {
                    motionEvent3.addBatch(historicalEventTime, pointerCoordsArr, 0);
                }
                i7++;
            }
            motionEvent2 = motionEvent3;
        } else if (view != null && !view.getMatrix().isIdentity()) {
            motionEvent2 = MotionEvent.obtain(motionEvent);
        } else if (view == null) {
            return false;
        } else {
            float scrollX = (float) (viewGroup.getScrollX() - view.getLeft());
            float scrollY = (float) (viewGroup.getScrollY() - view.getTop());
            motionEvent.offsetLocation(scrollX, scrollY);
            dispatchTouchEvent = view.dispatchTouchEvent(motionEvent);
            motionEvent.offsetLocation(-scrollX, -scrollY);
            return dispatchTouchEvent;
        }
        if (view == null) {
            return false;
        }
        motionEvent2.offsetLocation((float) (viewGroup.getScrollX() - view.getLeft()), (float) (viewGroup.getScrollY() - view.getTop()));
        if (!view.getMatrix().isIdentity()) {
            Matrix matrix = view.getMatrix();
            matrix.invert(matrix);
            motionEvent2.transform(matrix);
        }
        dispatchTouchEvent = view.dispatchTouchEvent(motionEvent2);
        motionEvent2.recycle();
        return dispatchTouchEvent;
    }
}
