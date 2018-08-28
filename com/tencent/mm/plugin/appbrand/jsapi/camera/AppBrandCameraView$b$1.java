package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.b;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;

class AppBrandCameraView$b$1 implements e {
    final /* synthetic */ b fOA;

    AppBrandCameraView$b$1(b bVar) {
        this.fOA = bVar;
    }

    public final void v(Bitmap bitmap) {
        if (bitmap == null) {
            AppBrandCameraView.a(this.fOA.fOz, -1, null, "bitmap is null");
        } else if (this.fOA.a(bitmap, AppBrandCameraView.j(this.fOA.fOz))) {
            AppBrandCameraView.a(this.fOA.fOz, 0, this.fOA.tw(AppBrandCameraView.j(this.fOA.fOz)), "");
        } else {
            AppBrandCameraView.a(this.fOA.fOz, -1, null, "save fail");
        }
    }

    public final void aiP() {
        AppBrandCameraView.a(this.fOA.fOz, -1, null, "take picture error");
    }
}
