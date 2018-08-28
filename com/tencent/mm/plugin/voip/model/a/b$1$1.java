package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.model.a.b.1;
import com.tencent.mm.plugin.voip.model.i;
import com.tencent.mm.protocal.c.caf;
import com.tencent.mm.sdk.platformtools.x;

class b$1$1 implements Runnable {
    final /* synthetic */ caf oNP;
    final /* synthetic */ 1 oNS;

    b$1$1(1 1, caf caf) {
        this.oNS = 1;
        this.oNP = caf;
    }

    public final void run() {
        i.bJI().bLb();
        a.eU(this.oNS.oNR.TAG, "steve:doublelink timer started!");
        this.oNS.oNR.oKs.a(this.oNP.swc, this.oNP.swd, this.oNP.swk);
        if (this.oNP.suK.rfy.siK != null) {
            this.oNS.oNR.oKs.aQ(this.oNP.suK.rfy.siK.toByteArray());
        } else {
            x.e(this.oNS.oNR.TAG, "multiRelayData.PeerId.Buffer.getBuffer() is null");
        }
        if (!(this.oNP.swi == null || this.oNP.swi.siK == null || this.oNP.swu == null || this.oNP.swu.siK == null)) {
            this.oNS.oNR.oKs.a(this.oNP.swi.siK.toByteArray(), this.oNP.swh, this.oNP.kpK, this.oNP.swu.siK.toByteArray());
        }
        this.oNS.oNR.oKs.h(this.oNP.swl, this.oNP.swm, this.oNP.swn, this.oNP.swo, this.oNP.swp);
        this.oNS.oNR.oKs.yz(this.oNP.swt);
        if (!(this.oNP.swr == null || this.oNP.sws == null || this.oNP.swr.siK == null || this.oNP.sws.siK == null)) {
            this.oNS.oNR.oKs.b(this.oNP.swq, this.oNP.swr.siK.toByteArray(), this.oNP.sws.siK.toByteArray());
        }
        if (this.oNP.suL.rfy.siK != null) {
            this.oNS.oNR.oKs.aR(this.oNP.suL.rfy.siK.toByteArray());
        } else {
            x.e(this.oNS.oNR.TAG, "multiRelayData.CapInfo.Buffer.getBuffer() is null");
        }
        this.oNS.oNR.oKs.yy(this.oNP.sww);
        this.oNS.oNR.oKs.oJX.oPm = this.oNP.swx;
        if (this.oNS.oNR.oKs.oJz) {
            this.oNS.oNR.oKs.oJz = false;
            if (this.oNS.oNR.oKs.oJv) {
                a.eU(this.oNS.oNR.TAG, "channel pre-connect already success, start talk");
                this.oNS.oNR.oKs.bJT();
            } else if (this.oNS.oNR.oKs.oJy) {
                a.eU(this.oNS.oNR.TAG, "channel pre-connect already failed");
                this.oNS.oNR.oKs.o(1, -9000, "");
                return;
            } else {
                a.eU(this.oNS.oNR.TAG, "channel pre-connect still connecting...");
            }
        } else {
            x.i(this.oNS.oNR.TAG, "isPreConnect is false");
        }
        this.oNS.oNR.oKs.bKb();
        this.oNS.oNR.oKs.bJZ();
    }
}
