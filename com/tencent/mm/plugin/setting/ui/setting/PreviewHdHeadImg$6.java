package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.aa.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.x;

class PreviewHdHeadImg$6 implements Runnable {
    final /* synthetic */ PreviewHdHeadImg mQr;

    PreviewHdHeadImg$6(PreviewHdHeadImg previewHdHeadImg) {
        this.mQr = previewHdHeadImg;
    }

    public final void run() {
        x.d("MicroMsg.PreviewHdHeadImg", "updateHeadImg hasUin:%b user:%s", new Object[]{Boolean.valueOf(g.Eg().Dx()), q.GF()});
        if (g.Eg().Dx()) {
            at.dBv.iy(c.A(q.GF(), true));
        }
        PreviewHdHeadImg.d(this.mQr);
    }
}
