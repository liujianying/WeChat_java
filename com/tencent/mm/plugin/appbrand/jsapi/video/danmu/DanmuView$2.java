package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

class DanmuView$2 implements Runnable {
    final /* synthetic */ DanmuView gcm;

    DanmuView$2(DanmuView danmuView) {
        this.gcm = danmuView;
    }

    public final void run() {
        DanmuView.a(this.gcm, false);
        this.gcm.invalidate();
    }
}
