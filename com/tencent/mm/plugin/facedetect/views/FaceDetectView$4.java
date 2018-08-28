package com.tencent.mm.plugin.facedetect.views;

import com.tencent.mm.sdk.platformtools.x;

class FaceDetectView$4 implements c {
    final /* synthetic */ FaceDetectView iTY;
    final /* synthetic */ c iUb;

    public FaceDetectView$4(FaceDetectView faceDetectView, c cVar) {
        this.iTY = faceDetectView;
        this.iUb = cVar;
    }

    public final void pF(int i) {
        x.i("MicroMsg.FaceDetectView", "hy: camera preview init done : %d", new Object[]{Integer.valueOf(i)});
        if (i == 0) {
            FaceDetectView.a(this.iTY, false);
            FaceDetectView.h(this.iTY);
        }
        if (this.iUb != null) {
            this.iUb.pF(i);
        }
    }
}
