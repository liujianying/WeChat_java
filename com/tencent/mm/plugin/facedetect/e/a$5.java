package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.plugin.facedetect.e.a.a;
import com.tencent.mm.plugin.facedetect.model.FaceContextData;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.mmsight.model.a.d$a;
import com.tencent.mm.sdk.platformtools.x;

class a$5 implements d$a {
    final /* synthetic */ a iSF;

    a$5(a aVar) {
        this.iSF = aVar;
    }

    public final void ZZ() {
        x.e("MicroMsg.FaceVideoRecorder", "hy: video capture error: %d", new Object[]{Integer.valueOf(1)});
        a.s(this.iSF).H(new Runnable() {
            final /* synthetic */ int eWY = 1;

            public final void run() {
                try {
                    if (a.g(a$5.this.iSF) != null) {
                        a.g(a$5.this.iSF).reset();
                    }
                    a.d(a$5.this.iSF);
                } catch (Exception e) {
                    x.e("MicroMsg.FaceVideoRecorder", "hy: onError, reset mediaRecorder error: %s", new Object[]{e.getMessage()});
                    a.d(a$5.this.iSF);
                } catch (Throwable th) {
                    a.d(a$5.this.iSF);
                    throw th;
                }
                synchronized (a.a(a$5.this.iSF)) {
                    try {
                        a.e(a$5.this.iSF, a.iSO);
                    } catch (Throwable th2) {
                        while (true) {
                            throw th2;
                        }
                    }
                }
                FaceDetectReporter.e(FaceContextData.aJD().iNq, 2, this.eWY);
            }
        });
    }
}
