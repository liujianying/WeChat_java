package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.qj;
import com.tencent.mm.protocal.c.aso;
import com.tencent.mm.sdk.platformtools.x;

class ac$1 implements Runnable {
    final /* synthetic */ qj npn;
    final /* synthetic */ aso npo;
    final /* synthetic */ ac npp;

    ac$1(ac acVar, qj qjVar, aso aso) {
        this.npp = acVar;
        this.npn = qjVar;
        this.npo = aso;
    }

    public final void run() {
        x.i("MicroMsg.SightCdnUpload", "event callback errcode %d", Integer.valueOf(this.npn.caW.result));
        if (this.npn.caW.result >= 0) {
            ac.a(this.npp);
            this.npp.a(this.npo);
            return;
        }
        this.npp.onError();
    }
}
