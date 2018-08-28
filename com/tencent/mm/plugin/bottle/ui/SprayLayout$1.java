package com.tencent.mm.plugin.bottle.ui;

class SprayLayout$1 implements Runnable {
    final /* synthetic */ SprayLayout hmO;

    SprayLayout$1(SprayLayout sprayLayout) {
        this.hmO = sprayLayout;
    }

    public final void run() {
        if (SprayLayout.a(this.hmO) == 0) {
            SprayLayout.b(this.hmO);
            SprayLayout.c(this.hmO).clearAnimation();
            SprayLayout.c(this.hmO).setVisibility(8);
            SprayLayout.d(this.hmO);
        } else if (SprayLayout.a(this.hmO) == 1) {
            SprayLayout.e(this.hmO).startAnimation(this.hmO.hmE);
            SprayLayout.e(this.hmO).setVisibility(0);
            SprayLayout.f(this.hmO).setVisibility(8);
            SprayLayout.c(this.hmO).setVisibility(8);
        } else if (SprayLayout.a(this.hmO) == 2) {
            SprayLayout.e(this.hmO).startAnimation(this.hmO.hmF);
            SprayLayout.f(this.hmO).startAnimation(this.hmO.hmE);
            SprayLayout.f(this.hmO).setVisibility(0);
        } else if (SprayLayout.a(this.hmO) == 3) {
            SprayLayout.e(this.hmO).clearAnimation();
            SprayLayout.e(this.hmO).setVisibility(8);
            SprayLayout.f(this.hmO).startAnimation(this.hmO.hmF);
            SprayLayout.c(this.hmO).startAnimation(this.hmO.hmE);
            SprayLayout.c(this.hmO).setVisibility(0);
        } else if (SprayLayout.a(this.hmO) == 4) {
            SprayLayout.c(this.hmO).startAnimation(this.hmO.hmG);
            SprayLayout.f(this.hmO).clearAnimation();
            SprayLayout.f(this.hmO).setVisibility(8);
        }
        if (SprayLayout.g(this.hmO) > SprayLayout.h(this.hmO)) {
            this.hmO.stop();
            return;
        }
        SprayLayout.j(this.hmO).postDelayed(SprayLayout.i(this.hmO), 280);
        SprayLayout.a(this.hmO, SprayLayout.k(this.hmO) % 5);
    }
}
