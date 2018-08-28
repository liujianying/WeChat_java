package com.tencent.tencentmap.mapsdk.a;

import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

class sr$1 implements OnGestureListener {
    private /* synthetic */ sr a;

    sr$1(sr srVar) {
        this.a = srVar;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public final void onLongPress(MotionEvent motionEvent) {
        if (sr.b(this.a)) {
            float x = sr.a(this.a).c().getX();
            float y = sr.a(this.a).c().getY();
            sr.a(this.a, true);
            sr.b(this.a, this.a.e());
            if (sr.e(this.a)) {
                this.a.g();
            }
            sr.a(this.a, x, y - ((float) sr.f(this.a)));
            if (sr.a(this.a).e() != null) {
                sr.a(this.a).e().c(new qy(this.a));
            }
        }
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (sr.b(this.a) && sr.c(this.a)) {
            return true;
        }
        sr.d(this.a).requestDisallowInterceptTouchEvent(false);
        return false;
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        this.a.n();
        if (sr.a(this.a).d() != null) {
            sr.a(this.a).d().a(new qy(this.a));
        } else if (this.a.e()) {
            this.a.g();
        } else {
            this.a.f();
        }
        return true;
    }
}
