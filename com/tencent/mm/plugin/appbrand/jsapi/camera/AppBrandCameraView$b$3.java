package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.b;

class AppBrandCameraView$b$3 implements Runnable {
    final /* synthetic */ b fOA;

    AppBrandCameraView$b$3(b bVar) {
        this.fOA = bVar;
    }

    public final void run() {
        this.fOA.stopRecord();
    }
}
