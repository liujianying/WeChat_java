package com.tencent.xweb.xwalk;

class g$2 implements Runnable {
    final /* synthetic */ g vEV;

    g$2(g gVar) {
        this.vEV = gVar;
    }

    public final void run() {
        if (this.vEV.vET != null) {
            this.vEV.vET.cleanup();
            this.vEV.vET = null;
            this.vEV.vEE.getLooper().quit();
            this.vEV.vEE = null;
        }
    }
}
