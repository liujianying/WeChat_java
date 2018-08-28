package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import com.tencent.mm.sdk.platformtools.x;

class DanmuView$5 implements Runnable {
    final /* synthetic */ DanmuView gcm;
    final /* synthetic */ int gcp;

    public DanmuView$5(DanmuView danmuView, int i) {
        this.gcm = danmuView;
        this.gcp = i;
    }

    public final void run() {
        synchronized (DanmuView.b(this.gcm)) {
            for (int size = DanmuView.a(this.gcm).size() - 1; size >= 0; size--) {
                d dVar = (d) DanmuView.a(this.gcm).get(size);
                if (dVar.ake() < this.gcp) {
                    break;
                }
                x.v("MicroMsg.DanmuView", "seekToPlayTime addBack i=%d showTime=%d", new Object[]{Integer.valueOf(size), Integer.valueOf(dVar.ake())});
                DanmuView.b(this.gcm).addFirst(dVar);
            }
        }
        DanmuView.c(this.gcm);
    }
}
