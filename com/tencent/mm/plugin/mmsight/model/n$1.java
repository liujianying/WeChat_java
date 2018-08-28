package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import android.hardware.Camera;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class n$1 implements Runnable {
    final /* synthetic */ long cXh;
    final /* synthetic */ long lgF;
    final /* synthetic */ int lgG;
    final /* synthetic */ n lgH;
    final /* synthetic */ Context val$context;

    n$1(n nVar, long j, long j2, Context context, int i) {
        this.lgH = nVar;
        this.lgF = j;
        this.cXh = j2;
        this.val$context = context;
        this.lgG = i;
    }

    public final void run() {
        x.i("MicroMsg.SightCamera.OpenCameraThread", "Start Open Camera thread[parent:%d this:%d] time:%d", new Object[]{Long.valueOf(this.lgF), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(bi.VF() - this.cXh)});
        synchronized (this.lgH.lock) {
            try {
                this.lgH.lgE = d.s(this.val$context, this.lgG);
            } catch (Exception e) {
                x.e("MicroMsg.SightCamera.OpenCameraThread", "openCamera failed e:%s", new Object[]{e.getMessage()});
                this.lgH.lgE = null;
            }
            if (this.lgH.lgD && this.lgH.lgE != null) {
                x.e("MicroMsg.SightCamera.OpenCameraThread", "thread time out now, release camera :%d ", new Object[]{Long.valueOf(bi.VF() - this.cXh)});
                try {
                    Camera camera = this.lgH.lgE.ddt;
                    camera.setPreviewCallback(null);
                    camera.stopPreview();
                    camera.release();
                    this.lgH.lgE = null;
                } catch (Exception e2) {
                    x.e("MicroMsg.SightCamera.OpenCameraThread", "realease Camera failed e:%s", new Object[]{e2.getMessage()});
                }
            }
            this.lgH.lock.notify();
        }
        return;
    }
}
