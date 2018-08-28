package com.tencent.mm.plugin.setting.ui.setting;

import android.graphics.Bitmap;
import com.tencent.mm.aa.g.b;
import com.tencent.mm.aa.q;
import com.tencent.mm.sdk.platformtools.x;

class PreviewHdHeadImg$3 implements b {
    final /* synthetic */ PreviewHdHeadImg mQr;
    final /* synthetic */ Bitmap mQt;

    PreviewHdHeadImg$3(PreviewHdHeadImg previewHdHeadImg, Bitmap bitmap) {
        this.mQr = previewHdHeadImg;
        this.mQt = bitmap;
    }

    public final int bd(int i, int i2) {
        PreviewHdHeadImg.c(this.mQr).Ku();
        x.i("MicroMsg.PreviewHdHeadImg", "onSceneEnd: errType=%d, errCode=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            Bitmap jU = q.Kp().jU(PreviewHdHeadImg.a(this.mQr));
            if (jU != null) {
                PreviewHdHeadImg.a(this.mQr, jU, q.Kp().c(PreviewHdHeadImg.a(this.mQr), true, false));
            } else {
                PreviewHdHeadImg.a(this.mQr, this.mQt, null);
            }
        } else {
            PreviewHdHeadImg.a(this.mQr, this.mQt, null);
        }
        return 0;
    }
}
