package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.b;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandCameraView$b$2 implements f {
    final /* synthetic */ b fOA;

    AppBrandCameraView$b$2(b bVar) {
        this.fOA = bVar;
    }

    public final void cN(boolean z) {
        x.i("MicroMsg.AppBrandCameraView", "onRecordFinish error %b", Boolean.valueOf(z));
        if (AppBrandCameraView.e(this.fOA.fOz) == null) {
            x.i("MicroMsg.AppBrandCameraView", "onRecordFinish recordView is null");
            b.a(this.fOA, -1, "camera is null", null, null);
            return;
        }
        this.fOA.fOz.fOu = 1;
        if (z) {
            b.a(this.fOA, -1, "stop error", null, null);
        } else {
            String videoFilePath = AppBrandCameraView.e(this.fOA.fOz).getVideoFilePath();
            int p = AppBrandCameraView.p(this.fOA.fOz);
            int q = AppBrandCameraView.q(this.fOA.fOz);
            AppBrandCameraView.e(this.fOA.fOz).getCameraRotation();
            this.fOA.a(d.ad(videoFilePath, p, q), AppBrandCameraView.r(this.fOA.fOz));
            b.a(this.fOA, 0, "", AppBrandCameraView.r(this.fOA.fOz), AppBrandCameraView.e(this.fOA.fOz).getVideoFilePath());
        }
        AppBrandCameraView.s(this.fOA.fOz);
        AppBrandCameraView.a(this.fOA.fOz, false);
    }
}
