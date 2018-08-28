package com.tencent.tencentmap.mapsdk.a;

class rl$1 implements Runnable {
    private /* synthetic */ rl a;

    rl$1(rl rlVar) {
        this.a = rlVar;
    }

    public final void run() {
        if (rl.a(this.a).computeScrollOffset()) {
            float currX = (((float) rl.a(this.a).getCurrX()) * 1.0f) / 10000.0f;
            float b = currX - rl.b(this.a);
            rl.a(this.a, rl.c(this.a) + ((double) b));
            if (rl.c(this.a) < 1.0d) {
                this.a.a(b);
            }
            rl.a(this.a, currX);
            if (rl.d(this.a)) {
                rl.f(this.a).postDelayed(rl.e(this.a), 5);
            }
            this.a.a.h().a(false);
            return;
        }
        this.a.d();
        if (this.a.c != null) {
            this.a.c.a();
        }
        rl.a(this.a, false);
        this.a.a.h().a(true);
    }
}
