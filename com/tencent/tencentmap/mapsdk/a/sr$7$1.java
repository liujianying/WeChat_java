package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.sr.7;

class sr$7$1 implements Runnable {
    private /* synthetic */ 7 a;

    sr$7$1(7 7) {
        this.a = 7;
    }

    public final void run() {
        sr.d(this.a.a).removeView(sr.n(this.a.a));
        if (sr.a(this.a.a).g() != null) {
            sr.o(this.a.a).h().g().a(new qy(this.a.a), sr.n(this.a.a));
        }
        sr.b(this.a.a, null);
    }
}
