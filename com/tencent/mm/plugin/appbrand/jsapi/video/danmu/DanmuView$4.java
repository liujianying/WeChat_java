package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import java.util.List;

class DanmuView$4 extends Thread {
    final /* synthetic */ DanmuView gcm;
    final /* synthetic */ List gco;

    public DanmuView$4(DanmuView danmuView, List list) {
        this.gcm = danmuView;
        this.gco = list;
    }

    public final void run() {
        synchronized (DanmuView.b(this.gcm)) {
            DanmuView.b(this.gcm).addAll(this.gco);
        }
        synchronized (DanmuView.a(this.gcm)) {
            DanmuView.a(this.gcm).addAll(this.gco);
        }
        this.gcm.postInvalidate();
    }
}
