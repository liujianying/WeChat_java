package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Point;
import android.hardware.Camera.Parameters;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.compatible.e.d.a.a;
import com.tencent.mm.plugin.scanner.util.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.List;

class BaseScanUI$3 implements Runnable {
    final /* synthetic */ BaseScanUI mHS;

    BaseScanUI$3(BaseScanUI baseScanUI) {
        this.mHS = baseScanUI;
    }

    public final void run() {
        try {
            if (BaseScanUI.f(this.mHS) == null) {
                x.w("MicroMsg.scanner.BaseScanUI", "scanCamera == null, in openCamera()");
                return;
            }
            if (!BaseScanUI.m(this.mHS)) {
                BaseScanUI.c(this.mHS, true);
            }
            if (BaseScanUI.f(this.mHS).isOpen()) {
                x.d("MicroMsg.scanner.BaseScanUI", "camera already open");
            } else {
                synchronized (BaseScanUI.n(this.mHS)) {
                    h f = BaseScanUI.f(this.mHS);
                    if (f.iOl) {
                        x.w("MicroMsg.scanner.ScanCamera", "in open(), previewing");
                        f.release();
                    }
                    int ze = d.ze();
                    long VG = bi.VG();
                    a s = d.s(f.bOb, ze);
                    if (s == null) {
                        x.e("MicroMsg.scanner.ScanCamera", "in open(), openCameraRes == null");
                        throw new IOException();
                    }
                    f.lfJ = false;
                    f.mNr = -1;
                    x.d("MicroMsg.scanner.ScanCamera", "openCamera done, cameraId=[%s] costTime=[%s]", new Object[]{Integer.valueOf(ze), Long.valueOf(bi.bI(VG))});
                    f.iOq = s.bYE;
                    f.iOp = s.bYE % 180 != 0;
                    f.ddt = s.ddt;
                    if (f.ddt == null) {
                        x.e("MicroMsg.scanner.ScanCamera", "in open(), camera == null, bNeedRotate=[%s]", new Object[]{Boolean.valueOf(f.iOp)});
                        throw new IOException();
                    }
                    boolean z;
                    int i;
                    Parameters parameters = f.ddt.getParameters();
                    Point point = f.iOn;
                    Point point2 = f.iOo;
                    if (9 == f.fNR || 10 == f.fNR || 7 == f.fNR || 11 == f.fNR) {
                        z = true;
                    } else {
                        z = false;
                    }
                    f.iOm = h.a(parameters, point, point2, z);
                    x.d("MicroMsg.scanner.ScanCamera", "getCameraResolution: " + f.iOn + " camera:" + f.iOm);
                    parameters.setPreviewSize(f.iOm.x, f.iOm.y);
                    f.btg();
                    try {
                        h.c(parameters);
                    } catch (Exception e) {
                        x.e("MicroMsg.scanner.ScanCamera", "set focus mode error: %s", new Object[]{e.getMessage()});
                    }
                    List supportedPreviewFormats = parameters.getSupportedPreviewFormats();
                    x.i("MicroMsg.scanner.ScanCamera", "supportedPreviewFormat:" + supportedPreviewFormats);
                    if (supportedPreviewFormats.contains(Integer.valueOf(17))) {
                        ze = 0;
                        i = 1;
                    } else if (supportedPreviewFormats.contains(Integer.valueOf(842094169))) {
                        ze = 1;
                        i = 0;
                    } else {
                        ze = 0;
                        i = 0;
                    }
                    if (i != 0) {
                        x.i("MicroMsg.scanner.ScanCamera", "Preview support NV21");
                        parameters.setPreviewFormat(17);
                    } else if (ze != 0) {
                        x.i("MicroMsg.scanner.ScanCamera", "Preview not support NV21, but support YV12");
                        parameters.setPreviewFormat(842094169);
                    } else {
                        x.i("MicroMsg.scanner.ScanCamera", "Preview not support NV21 and YV12. Use format: %s", new Object[]{supportedPreviewFormats.get(0)});
                        parameters.setPreviewFormat(((Integer) supportedPreviewFormats.get(0)).intValue());
                    }
                    f.ddt.setParameters(parameters);
                    x.d("MicroMsg.scanner.BaseScanUI", "scanCamera.open done");
                    BaseScanUI.c(this.mHS, false);
                }
            }
            ah.i(new 1(this), 50);
            BaseScanUI.q(this.mHS);
        } catch (Throwable e2) {
            x.w("MicroMsg.scanner.BaseScanUI", "Exception in scanCamera.open(), [%s]", new Object[]{e2.toString()});
            x.printErrStackTrace("MicroMsg.scanner.BaseScanUI", e2, "", new Object[0]);
            BaseScanUI.o(this.mHS);
        }
    }
}
