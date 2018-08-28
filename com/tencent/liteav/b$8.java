package com.tencent.liteav;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

class b$8 implements OnScaleGestureListener {
    final /* synthetic */ b a;

    b$8(b bVar) {
        this.a = bVar;
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float f = 1.1f;
        int d = this.a.d();
        if (d > 0) {
            int f2;
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (scaleFactor > 1.0f) {
                float f3 = ((0.2f / ((float) d)) * ((float) (d - b.f(this.a)))) + 1.0f;
                if (f3 > 1.1f) {
                    f = f3;
                }
            } else if (scaleFactor < 1.0f) {
                f = 1.0f - ((0.2f / ((float) d)) * ((float) b.f(this.a)));
                if (f >= 0.9f) {
                    f = 0.9f;
                }
            } else {
                f = scaleFactor;
            }
            int round = Math.round(((float) b.f(this.a)) * f);
            if (round == b.f(this.a)) {
                if (f > 1.0f) {
                    round++;
                } else if (f < 1.0f) {
                    round--;
                }
            }
            if (round >= d) {
                round = d;
            }
            if (round <= 1) {
                round = 1;
            }
            if (f > 1.0f) {
                if (round < b.f(this.a)) {
                    f2 = b.f(this.a);
                }
                f2 = round;
            } else {
                if (f < 1.0f && round > b.f(this.a)) {
                    f2 = b.f(this.a);
                }
                f2 = round;
            }
            b.d(this.a, f2);
            this.a.a(b.f(this.a));
        }
        return false;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }
}
