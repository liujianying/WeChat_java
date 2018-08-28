package com.tencent.mm.ui.widget.sortlist;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class a$1 extends SimpleOnGestureListener {
    final /* synthetic */ a uNn;

    a$1(a aVar) {
        this.uNn = aVar;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (a.a(this.uNn) && a.b(this.uNn)) {
            int width = a.c(this.uNn).getWidth() / 5;
            if (f > a.d(this.uNn)) {
                if (a.e(this.uNn) > (-width)) {
                    a.c(this.uNn).aE(f);
                }
            } else if (f < (-a.d(this.uNn)) && a.e(this.uNn) < width) {
                a.c(this.uNn).aE(f);
            }
            a.f(this.uNn);
        }
        return false;
    }
}
