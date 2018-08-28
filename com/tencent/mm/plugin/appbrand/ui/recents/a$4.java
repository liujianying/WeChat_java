package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.app.e;

class a$4 implements Runnable {
    final /* synthetic */ a gyS;
    final /* synthetic */ long gyT;

    a$4(a aVar, long j) {
        this.gyS = aVar;
        this.gyT = j;
    }

    public final void run() {
        this.gyS.runOnUiThread(new 1(this, a.k(this.gyS).k(e.abg().fmt.bN(this.gyT))));
    }
}
