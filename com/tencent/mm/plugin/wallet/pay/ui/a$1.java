package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.g.a.gv;
import com.tencent.mm.g.a.gv.b;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements Runnable {
    final /* synthetic */ gv pfs;
    final /* synthetic */ a pft;

    a$1(a aVar, gv gvVar) {
        this.pft = aVar;
        this.pfs = gvVar;
    }

    public final void run() {
        x.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback");
        b bVar = this.pfs.bPX;
        if (bVar != null && bVar.bLW) {
            x.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is true");
            this.pft.bNx();
            if (this.pft.pfr != null) {
                this.pft.pfr.c(bVar.bLW, bVar.bQb, bVar.bQc);
            }
        } else if (bVar == null || bVar.bLW) {
            x.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result == null");
        } else {
            this.pft.bNx();
            if (this.pft.pfr != null) {
                this.pft.pfr.c(bVar.bLW, bVar.bQb, bVar.bQc);
            }
            x.e("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is false");
        }
    }
}
