package com.tencent.mm.plugin.appbrand.jsapi.camera.a;

class b$2 implements Runnable {
    final /* synthetic */ b fOW;
    final /* synthetic */ int fOX = 2;
    final /* synthetic */ String fOY;
    final /* synthetic */ int fOZ;
    final /* synthetic */ int fPa;

    b$2(b bVar, String str) {
        this.fOW = bVar;
        this.fOY = str;
        this.fOZ = 0;
        this.fPa = 0;
    }

    public final void run() {
        if (this.fOW.fOP != null) {
            this.fOW.fOP.K(this.fOX, this.fOY);
        }
    }
}
