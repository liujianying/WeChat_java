package com.tencent.mm.plugin.facedetect.views;

import com.tencent.mm.memory.a;
import com.tencent.mm.plugin.facedetect.model.d.b;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c;

class FaceDetectCameraView$c$4 implements b {
    final /* synthetic */ c iTy;

    FaceDetectCameraView$c$4(c cVar) {
        this.iTy = cVar;
    }

    public final void av(byte[] bArr) {
        if (!FaceDetectCameraView.n(this.iTy.iTq)) {
            if (FaceDetectCameraView.o(this.iTy.iTq) == null) {
                FaceDetectCameraView.a(this.iTy.iTq, com.tencent.mm.plugin.facedetect.model.c.iNi.i(Integer.valueOf(bArr.length)));
            }
            System.arraycopy(bArr, 0, FaceDetectCameraView.o(this.iTy.iTq), 0, bArr.length);
            FaceDetectCameraView.a(this.iTy.iTq, bArr);
        }
        com.tencent.mm.plugin.facedetect.model.c.iNi.F(bArr);
        f.aJL().post(new 1(this));
    }

    public final a<byte[]> aJC() {
        return com.tencent.mm.plugin.facedetect.model.c.iNi;
    }
}
