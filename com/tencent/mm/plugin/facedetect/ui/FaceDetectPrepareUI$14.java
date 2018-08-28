package com.tencent.mm.plugin.facedetect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI.c;

class FaceDetectPrepareUI$14 implements OnClickListener {
    final /* synthetic */ int bFq;
    final /* synthetic */ int bFr;
    final /* synthetic */ String dJG;
    final /* synthetic */ FaceDetectPrepareUI iRf;
    final /* synthetic */ boolean iRo;
    final /* synthetic */ c iRp;

    FaceDetectPrepareUI$14(FaceDetectPrepareUI faceDetectPrepareUI, boolean z, c cVar, int i, int i2, String str) {
        this.iRf = faceDetectPrepareUI;
        this.iRo = z;
        this.iRp = cVar;
        this.bFq = i;
        this.bFr = i2;
        this.dJG = str;
    }

    public final void onClick(View view) {
        if (!this.iRo) {
            if (this.iRp != null) {
                this.iRp.j(this.bFq, this.bFr, this.dJG);
            }
            this.iRf.a(this.bFq, this.bFr, this.dJG, null);
        } else if (FaceDetectPrepareUI.c(this.iRf) != null) {
            FaceDetectPrepareUI.c(this.iRf).aJv();
        }
    }
}
