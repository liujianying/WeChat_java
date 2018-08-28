package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.a;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.concurrent.atomic.AtomicBoolean;

class AppBrandCameraView$c implements a, c.a {
    private int duration;
    private c fOB;
    AtomicBoolean fOC;
    private int fOD;
    final /* synthetic */ AppBrandCameraView fOz;

    private AppBrandCameraView$c(AppBrandCameraView appBrandCameraView) {
        this.fOz = appBrandCameraView;
        this.fOC = new AtomicBoolean(false);
        this.fOD = 200;
        this.duration = this.fOD;
    }

    /* synthetic */ AppBrandCameraView$c(AppBrandCameraView appBrandCameraView, byte b) {
        this(appBrandCameraView);
    }

    public final void init() {
        this.fOB = new d();
        this.fOB.init();
        this.fOB.fPb = this;
        AppBrandCameraView.a(this.fOz, 4);
        if (AppBrandCameraView.v(this.fOz) > 0) {
            this.duration = BaseReportManager.MAX_READ_COUNT / AppBrandCameraView.v(this.fOz);
        }
    }

    public final void n(byte[] bArr, int i, int i2) {
        if (this.fOC.get()) {
            x.d("MicroMsg.AppBrandCameraView", "[onFrameData] isScanPause, return");
        } else if (this.fOB != null && AppBrandCameraView.e(this.fOz) != null) {
            this.fOB.a(bArr, i, i2, AppBrandCameraView.w(this.fOz), AppBrandCameraView.e(this.fOz).getCameraRotation());
        }
    }

    public final void J(int i, String str) {
        if (this.fOC.compareAndSet(false, true)) {
            ah.i(new 1(this), (long) this.duration);
            x.i("MicroMsg.AppBrandCameraView", "resultText:%s, resultType:%d", new Object[]{str, Integer.valueOf(i)});
            switch (i) {
                case 1:
                    e.a(AppBrandCameraView.b(this.fOz), this.fOz.getCameraId(), "qrcode", str);
                    return;
                case 2:
                    e.a(AppBrandCameraView.b(this.fOz), this.fOz.getCameraId(), "barcode", str);
                    return;
                default:
                    x.w("MicroMsg.AppBrandCameraView", "resultType:%d is not support, ignore");
                    return;
            }
        }
    }

    public final void aiM() {
        x.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, takePicture err");
    }

    public final void aiN() {
        x.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, startRecord err");
    }

    public final void aiO() {
        x.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, safeStopRecord err");
    }

    public final void release() {
        if (this.fOB != null) {
            this.fOB.release();
        }
    }
}
