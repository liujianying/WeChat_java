package com.tencent.mm.plugin.appbrand.jsapi.f.a;

class c$9 implements Runnable {
    final /* synthetic */ c fTi;

    c$9(c cVar) {
        this.fTi = cVar;
    }

    public final void run() {
        if (this.fTi.fSW != null) {
            this.fTi.fSW.getView().setVisibility(8);
            this.fTi.fSW.clean();
            this.fTi.fSW.onDestroy();
        }
    }
}
