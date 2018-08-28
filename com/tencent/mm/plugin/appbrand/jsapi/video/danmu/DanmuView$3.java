package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

class DanmuView$3 implements Runnable {
    final /* synthetic */ DanmuView gcm;
    final /* synthetic */ d gcn;

    public DanmuView$3(DanmuView danmuView, d dVar) {
        this.gcm = danmuView;
        this.gcn = dVar;
    }

    public final void run() {
        synchronized (DanmuView.a(this.gcm)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= DanmuView.a(this.gcm).size()) {
                    break;
                } else if (this.gcn.ake() <= ((d) DanmuView.a(this.gcm).get(i2)).ake()) {
                    DanmuView.a(this.gcm).add(i2, this.gcn);
                    break;
                } else {
                    i = i2 + 1;
                }
            }
        }
    }
}
