package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.g.15;

class g$15$3 implements Runnable {
    final /* synthetic */ 15 fdj;
    final /* synthetic */ int fdk;

    g$15$3(15 15, int i) {
        this.fdj = 15;
        this.fdk = i;
    }

    public final void run() {
        if (this.fdj.fdd.fcB != null) {
            this.fdj.fdd.fcB.setProgress(this.fdk);
        }
    }
}
