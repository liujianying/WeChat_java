package com.tencent.mm.plugin.bottle.ui;

class ThrowBottleAnimUI$1 implements Runnable {
    final /* synthetic */ ThrowBottleAnimUI hnb;

    ThrowBottleAnimUI$1(ThrowBottleAnimUI throwBottleAnimUI) {
        this.hnb = throwBottleAnimUI;
    }

    public final void run() {
        if (ThrowBottleAnimUI.a(this.hnb) != null && !ThrowBottleAnimUI.a(this.hnb).isFinishing() && ThrowBottleAnimUI.b(this.hnb) != null && ThrowBottleAnimUI.c(this.hnb) != null) {
            ThrowBottleAnimUI.b(this.hnb).setVisibility(0);
            ThrowBottleAnimUI.a(this.hnb).hkD = false;
            ThrowBottleAnimUI.a(this.hnb).nm(-1);
            ThrowBottleAnimUI.d(this.hnb);
            ThrowBottleAnimUI.e(this.hnb);
            ThrowBottleAnimUI.f(this.hnb);
            ThrowBottleAnimUI.c(this.hnb).startAnimation(ThrowBottleAnimUI.g(this.hnb));
        }
    }
}
