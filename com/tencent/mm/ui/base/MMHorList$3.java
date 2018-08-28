package com.tencent.mm.ui.base;

import android.graphics.Rect;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

class MMHorList$3 extends SimpleOnGestureListener {
    final /* synthetic */ MMHorList tvP;

    MMHorList$3(MMHorList mMHorList) {
        this.tvP = mMHorList;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        return this.tvP.crg();
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return this.tvP.aC(f);
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        MMHorList.a(this.tvP, MMHorList.c(this.tvP) + ((int) f));
        this.tvP.requestLayout();
        return true;
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        Rect rect = new Rect();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.tvP.getChildCount()) {
                break;
            }
            View childAt = this.tvP.getChildAt(i2);
            rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                if (MMHorList.d(this.tvP) != null) {
                    MMHorList.d(this.tvP).onItemClick(this.tvP, childAt, (MMHorList.e(this.tvP) + 1) + i2, MMHorList.f(this.tvP).getItemId((MMHorList.e(this.tvP) + 1) + i2));
                }
                if (MMHorList.g(this.tvP) != null) {
                    MMHorList.g(this.tvP).onItemSelected(this.tvP, childAt, (MMHorList.e(this.tvP) + 1) + i2, MMHorList.f(this.tvP).getItemId((MMHorList.e(this.tvP) + 1) + i2));
                }
            } else {
                i = i2 + 1;
            }
        }
        return true;
    }
}
