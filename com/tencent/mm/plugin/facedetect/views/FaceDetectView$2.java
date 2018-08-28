package com.tencent.mm.plugin.facedetect.views;

import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.sdk.platformtools.ah;

class FaceDetectView$2 implements Runnable {
    final /* synthetic */ String dMs;
    final /* synthetic */ FaceDetectView iTY;

    FaceDetectView$2(FaceDetectView faceDetectView, String str) {
        this.iTY = faceDetectView;
        this.dMs = str;
    }

    public final void run() {
        ah.A(new 1(this, o.AT(this.dMs)));
    }
}
