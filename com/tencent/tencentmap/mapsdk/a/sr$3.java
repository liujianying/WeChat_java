package com.tencent.tencentmap.mapsdk.a;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class sr$3 implements OnTouchListener {
    private /* synthetic */ sr a;

    sr$3(sr srVar) {
        this.a = srVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (sr.b(this.a) && sr.c(this.a)) {
                    sr.a(this.a, false);
                    this.a.n();
                    new StringBuilder().append(sr.e(this.a));
                    if (sr.e(this.a)) {
                        this.a.f();
                        sr.b(this.a, false);
                    }
                    if (sr.a(this.a).e() != null) {
                        sr.a(this.a).e().b(new qy(this.a));
                        break;
                    }
                }
                break;
            case 2:
                if (sr.b(this.a) && sr.c(this.a)) {
                    float x = sr.a(this.a).c().getX();
                    float y = sr.a(this.a).c().getY();
                    sr.a(this.a, x, y - ((float) sr.f(this.a)));
                    new StringBuilder().append(x).append(",").append(y);
                    if (sr.a(this.a).e() != null) {
                        sr.a(this.a).e().a(new qy(this.a));
                    }
                    return true;
                }
        }
        return sr.i(this.a).onTouchEvent(motionEvent);
    }
}
