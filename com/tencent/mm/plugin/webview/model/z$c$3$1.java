package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.plugin.webview.model.z.c.3;

class z$c$3$1 implements Runnable {
    final /* synthetic */ int oCo;
    final /* synthetic */ 3 pRA;

    z$c$3$1(3 3, int i) {
        this.pRA = 3;
        this.oCo = i;
    }

    public final void run() {
        if (this.oCo == 1) {
            this.pRA.pRy.goBack();
        } else {
            this.pRA.pRy.Qk(this.pRA.pRz);
        }
    }
}
