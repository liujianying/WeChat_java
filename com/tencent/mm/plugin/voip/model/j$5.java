package com.tencent.mm.plugin.voip.model;

import java.util.TimerTask;

class j$5 extends TimerTask {
    final /* synthetic */ j oKq;

    j$5(j jVar) {
        this.oKq = jVar;
    }

    public final void run() {
        j.d(this.oKq);
        if (this.oKq.oJX.oPE != 0 || j.e(this.oKq) > 10) {
            j.f(this.oKq);
            j.g(this.oKq).cancel();
            j.h(this.oKq);
        }
    }
}
