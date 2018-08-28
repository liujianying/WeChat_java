package com.tencent.mm.plugin.facedetect.ui;

import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.b.d;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectPrepareUI$9 implements d {
    final /* synthetic */ FaceDetectPrepareUI iRf;
    private double iRj = 0.0d;

    FaceDetectPrepareUI$9(FaceDetectPrepareUI faceDetectPrepareUI) {
        this.iRf = faceDetectPrepareUI;
    }

    public final void s(double d) {
        x.i("MicroMsg.FaceDetectPrepareUI", "hy: reg on process : %f", new Object[]{Double.valueOf(d)});
        this.iRj = 100.0d * d;
    }

    public final void a(int i, int i2, int i3, String str) {
        x.i("MicroMsg.FaceDetectPrepareUI", "onError scene: %d, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        FaceDetectPrepareUI.a(this.iRf, i2, i3, str, this.iRf.getString(h.soter_face_err_msg_retry));
    }

    public final void e(String str, Bundle bundle) {
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onUploadEnd");
        int pD = FaceDetectPrepareUI.pD(0);
        if (pD != 0) {
            this.iRf.d(pD, 0, str, bundle);
        }
        if (FaceDetectPrepareUI.c(this.iRf) != null) {
            FaceDetectPrepareUI.c(this.iRf).a(pD, str, bundle);
        }
    }

    public final void i(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
        int pD = FaceDetectPrepareUI.pD(i);
        if (!(pD == 0 && i2 == 0)) {
            this.iRf.d(pD, i2, str, null);
        }
        if (FaceDetectPrepareUI.c(this.iRf) != null) {
            FaceDetectPrepareUI.c(this.iRf).i(pD, i2, str, lVar);
        }
    }
}
