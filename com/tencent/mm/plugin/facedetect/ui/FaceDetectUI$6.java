package com.tencent.mm.plugin.facedetect.ui;

import android.graphics.RectF;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.model.h;
import com.tencent.mm.plugin.facedetect.views.FaceDetectDecorView;
import com.tencent.mm.plugin.facedetect.views.FaceDetectView;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectUI$6 implements Runnable {
    final /* synthetic */ FaceDetectUI iRF;

    FaceDetectUI$6(FaceDetectUI faceDetectUI) {
        this.iRF = faceDetectUI;
    }

    public final void run() {
        int[] iArr = null;
        x.i("MicroMsg.FaceDetectUI", "alvinluo dismiss cover and start capture");
        FaceDetectUI.h(this.iRF).aKy();
        FaceDetectUI.h(this.iRF).aKz();
        FaceDetectUI faceDetectUI = this.iRF;
        if (h.iNB == null) {
            h.iNB = new h();
        }
        faceDetectUI.iRq = h.iNB;
        h hVar = faceDetectUI.iRq;
        hVar.irJ = 0;
        hVar.iNz = null;
        hVar.iNA = -1;
        hVar = faceDetectUI.iRq;
        g gVar = f.iNu.iNv.iPA;
        if (gVar.iNy == null) {
            x.e("MicroMsg.FaceDetectNativeManager", "hy: get all motion not init");
        } else {
            iArr = gVar.iNy.engineGetAllMotions();
        }
        hVar.iNz = iArr;
        hVar.iNA = hVar.iNz == null ? 0 : hVar.iNz.length;
        faceDetectUI.iuY = true;
        FaceDetectView faceDetectView = faceDetectUI.iRw;
        RectF rectF = new RectF((float) faceDetectUI.iRx.getLeft(), (float) faceDetectUI.iRx.getTop(), (float) faceDetectUI.iRx.getRight(), (float) faceDetectUI.iRx.getBottom());
        FaceDetectDecorView faceDetectDecorView = faceDetectView.iTH;
        String str = "MicroMsg.FaceDetectDecorView";
        String str2 = "hy: trigger showCover cover: %s, old: %s";
        Object[] objArr = new Object[2];
        objArr[0] = rectF.toString();
        objArr[1] = faceDetectDecorView.iTE == null ? "null" : faceDetectDecorView.iTE.toString();
        x.i(str, str2, objArr);
        faceDetectDecorView.iTC = true;
        if (faceDetectDecorView.iTE == null || !faceDetectDecorView.iTE.equals(rectF)) {
            faceDetectDecorView.iTE = rectF;
            x.i("MicroMsg.FaceDetectDecorView", "alvinluo invalidate %s", new Object[]{faceDetectDecorView.iTE.toString()});
            faceDetectDecorView.invalidate();
        }
        faceDetectUI.aKv();
    }
}
