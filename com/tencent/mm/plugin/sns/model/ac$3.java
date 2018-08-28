package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.protocal.c.aso;
import com.tencent.mm.protocal.c.ath;
import com.tencent.mm.sdk.platformtools.x;

class ac$3 implements Runnable {
    final /* synthetic */ aso npo;
    final /* synthetic */ ac npp;

    ac$3(ac acVar, aso aso) {
        this.npp = acVar;
        this.npo = aso;
    }

    public final void run() {
        this.npo.rUQ++;
        try {
            x.i("MicroMsg.SightCdnUpload", "add try count %d", Integer.valueOf(this.npo.rUQ));
            ath ath = (ath) new ath().aG(this.npp.npk.nJM);
            ath.rWE = this.npo;
            this.npp.npk.nJM = ath.toByteArray();
            af.byd().a(this.npp.npk.nJc, this.npp.npk);
        } catch (Exception e) {
            x.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in checkUploadaddCount %s", e.getMessage());
        }
    }
}
