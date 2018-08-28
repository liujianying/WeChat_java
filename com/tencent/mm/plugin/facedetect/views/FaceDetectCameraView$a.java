package com.tencent.mm.plugin.facedetect.views;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class FaceDetectCameraView$a extends ag {
    private WeakReference<FaceDetectCameraView> xd;

    /* synthetic */ FaceDetectCameraView$a(FaceDetectCameraView faceDetectCameraView, byte b) {
        this(faceDetectCameraView);
    }

    private FaceDetectCameraView$a(FaceDetectCameraView faceDetectCameraView) {
        super(Looper.getMainLooper());
        this.xd = new WeakReference(faceDetectCameraView);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.xd == null || this.xd.get() == null) {
            x.e("MicroMsg.FaceDetectCameraView", "hy: no referenced view. exit");
        } else if (message.what == 1) {
            FaceCharacteristicsResult faceCharacteristicsResult = (FaceCharacteristicsResult) message.obj;
            if (FaceCharacteristicsResult.pu(faceCharacteristicsResult.errCode)) {
                if (FaceDetectCameraView.a((FaceDetectCameraView) this.xd.get()) != null) {
                    FaceDetectCameraView.a((FaceDetectCameraView) this.xd.get()).d(faceCharacteristicsResult);
                }
            } else if (FaceCharacteristicsResult.pt(faceCharacteristicsResult.errCode)) {
                if (FaceDetectCameraView.a((FaceDetectCameraView) this.xd.get()) != null) {
                    FaceDetectCameraView.a((FaceDetectCameraView) this.xd.get()).a(faceCharacteristicsResult.errCode, faceCharacteristicsResult.Yy);
                }
            } else if (FaceDetectCameraView.a((FaceDetectCameraView) this.xd.get()) != null) {
                FaceDetectCameraView.a((FaceDetectCameraView) this.xd.get()).c(faceCharacteristicsResult);
            }
        }
    }
}
