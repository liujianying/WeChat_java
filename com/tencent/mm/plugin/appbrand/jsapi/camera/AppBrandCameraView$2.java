package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.a;

class AppBrandCameraView$2 implements a {
    final /* synthetic */ AppBrandCameraView fOz;

    AppBrandCameraView$2(AppBrandCameraView appBrandCameraView) {
        this.fOz = appBrandCameraView;
    }

    public final void n(byte[] bArr, int i, int i2) {
        if (AppBrandCameraView.c(this.fOz) != null) {
            AppBrandCameraView.c(this.fOz).n(bArr, i, i2);
        }
    }
}
