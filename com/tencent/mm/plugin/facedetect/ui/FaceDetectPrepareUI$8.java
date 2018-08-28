package com.tencent.mm.plugin.facedetect.ui;

import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.b.c;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectPrepareUI$8 implements c {
    final /* synthetic */ FaceDetectPrepareUI iRf;

    FaceDetectPrepareUI$8(FaceDetectPrepareUI faceDetectPrepareUI) {
        this.iRf = faceDetectPrepareUI;
    }

    public final void e(long j, byte[] bArr) {
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onGetConfigSuccess, bioId: %d, isCancel: %b", new Object[]{Long.valueOf(j), Boolean.valueOf(FaceDetectPrepareUI.b(this.iRf))});
        if (!FaceDetectPrepareUI.b(this.iRf)) {
            FaceDetectPrepareUI.a(this.iRf, j);
            FaceDetectPrepareUI.a(this.iRf, bArr);
            FaceDetectPrepareUI.a(this.iRf, j, bArr);
        }
    }

    public final void ab(int i, String str) {
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onGetConfigFailed, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(90015), str});
        FaceDetectPrepareUI.a(this.iRf, FaceDetectPrepareUI.pD(i), 90015, str, this.iRf.getString(h.face_detect_init_err));
    }
}
