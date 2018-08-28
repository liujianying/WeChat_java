package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.sr.5;

class sr$5$1 implements Runnable {
    private /* synthetic */ 5 a;

    sr$5$1(5 5) {
        this.a = 5;
    }

    public final void run() {
        sr.d(this.a.a).removeView(sr.j(this.a.a));
        sr.d(this.a.a).removeView(sr.n(this.a.a));
        sr.k(this.a.a).setAnimationListener(null);
    }
}
