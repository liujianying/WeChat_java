package com.tencent.mm.plugin.facedetect.views;

import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import com.tencent.mm.plugin.facedetect.model.d;
import com.tencent.mm.plugin.facedetect.model.d.a;
import com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectCameraView$c$3 implements PreviewCallback {
    final /* synthetic */ c iTy;

    FaceDetectCameraView$c$3(c cVar) {
        this.iTy = cVar;
    }

    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        x.v("MicroMsg.FaceDetectCameraView", "hy: on preview callback");
        d aJB = d.aJB();
        synchronized (d.mLock) {
            x.v("MicroMsg.FaceCameraDataCallbackHolder", "hy: publish");
            if (aJB.iNl == null || aJB.iNl.size() == 0) {
                x.w("MicroMsg.FaceCameraDataCallbackHolder", "hy: nothing's listening to preview data");
            } else if (bArr == null || bArr.length == 0) {
                x.w("MicroMsg.FaceCameraDataCallbackHolder", "hy: null camera data got");
            } else {
                for (a aVar : aJB.iNl) {
                    int length = bArr.length;
                    aVar.data = (byte[]) aVar.iNm.aJC().c(Integer.valueOf(length));
                    System.arraycopy(bArr, 0, aVar.data, 0, length);
                    aVar.iNm.av(aVar.data);
                }
            }
        }
    }
}
