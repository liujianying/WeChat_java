package com.tencent.mm.plugin.appbrand.jsapi.video;

class c$1 implements Runnable {
    final /* synthetic */ AppBrandVideoView gbm;
    final /* synthetic */ c gbo;

    c$1(c cVar, AppBrandVideoView appBrandVideoView) {
        this.gbo = cVar;
        this.gbm = appBrandVideoView;
    }

    public final void run() {
        this.gbm.clean();
    }
}
