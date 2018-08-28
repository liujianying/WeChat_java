package com.tencent.mm.plugin.product.ui;

import com.tencent.mm.g.a.mi;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.protocal.c.cf;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class f$2 implements Runnable {
    final /* synthetic */ f lSK;
    final /* synthetic */ mi lSL;

    f$2(f fVar, mi miVar) {
        this.lSK = fVar;
        this.lSL = miVar;
    }

    public final void run() {
        x.d("MicroMsg.MallProductUI", "JSOAUTH errCode[%s], isAccept[%s]", new Object[]{Integer.valueOf(this.lSL.bXb.errCode), Boolean.valueOf(this.lSL.bXb.bXc)});
        if (this.lSL.bXb.errCode == 0) {
            c c = f.c(this.lSK);
            mi miVar = this.lSL;
            cf cfVar = new cf();
            cfVar.hbL = miVar.bXb.userName;
            cfVar.rcz = miVar.bXb.bXe;
            cfVar.rcA = miVar.bXb.bXf;
            cfVar.eJI = miVar.bXb.bXg;
            cfVar.eJJ = miVar.bXb.bXh;
            cfVar.eJQ = miVar.bXb.bXi;
            cfVar.jQf = miVar.bXb.bXj;
            if (!(bi.oW(cfVar.hbL) || bi.oW(cfVar.rcz))) {
                c.lQR = cfVar;
            }
        }
        f.d(this.lSK);
    }
}
