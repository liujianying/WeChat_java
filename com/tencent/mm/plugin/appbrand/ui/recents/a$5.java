package com.tencent.mm.plugin.appbrand.ui.recents;

class a$5 implements Runnable {
    final /* synthetic */ a gyS;

    a$5(a aVar) {
        this.gyS = aVar;
    }

    public final void run() {
        if (a.m(this.gyS).SU != null && a.m(this.gyS).SU.getHeight() > 0 && a.g(this.gyS) != null) {
            a.g(this.gyS).scrollBy(0, a.m(this.gyS).SU.getHeight());
        }
    }
}
