package com.tencent.mm.plugin.facedetect.ui;

import android.graphics.Bitmap;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI.12;
import com.tencent.mm.plugin.facedetect.ui.a.b;

class FaceDetectPrepareUI$12$2 implements Runnable {
    final /* synthetic */ 12 iRl;
    final /* synthetic */ OnClickListener iRm;
    final /* synthetic */ Bitmap iRn;

    FaceDetectPrepareUI$12$2(12 12, OnClickListener onClickListener, Bitmap bitmap) {
        this.iRl = 12;
        this.iRm = onClickListener;
        this.iRn = bitmap;
    }

    public final void run() {
        b a = a.a(this.iRl.iRf, this.iRm);
        a.iQz = this.iRn;
        this.iRl.iRf.a(false, false, a);
    }
}
