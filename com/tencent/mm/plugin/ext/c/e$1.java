package com.tencent.mm.plugin.ext.c;

import com.tencent.mm.g.a.no;
import com.tencent.mm.plugin.ext.c.d.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.x;

class e$1 extends bd<e$a> {
    final /* synthetic */ b iKS;
    final /* synthetic */ e iKT;

    e$1(e eVar, e$a e_a, b bVar) {
        this.iKT = eVar;
        this.iKS = bVar;
        super(5000, e_a);
    }

    private e$a aJk() {
        try {
            x.d("MicroMsg.ExtQrCodeHandler", "hy: start scan qrcode");
            if (this.iKS != null) {
                no noVar = new no();
                noVar.bYB.width = this.iKS.Zh;
                noVar.bYB.height = this.iKS.Zi;
                noVar.bYB.bYD = this.iKS.iKQ;
                noVar.bYB.bYE = this.iKS.bYE;
                noVar.bYB.bYC = this.iKS.bYC;
                noVar.bYB.bYF = new 1(this);
                a.sFg.m(noVar);
            } else {
                x.w("MicroMsg.ExtQrCodeHandler", "hy: qrcode data not retrieved");
                cf(null);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ExtQrCodeHandler", e, "hy: error when syncTaskScanQrCode", new Object[0]);
            cf(null);
        }
        return null;
    }
}
