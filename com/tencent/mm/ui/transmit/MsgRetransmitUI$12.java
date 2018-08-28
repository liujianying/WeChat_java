package com.tencent.mm.ui.transmit;

import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g.a;

class MsgRetransmitUI$12 implements Runnable {
    final /* synthetic */ String bAd;
    final /* synthetic */ bd dAB;
    final /* synthetic */ MsgRetransmitUI uDL;
    final /* synthetic */ a uDQ;
    final /* synthetic */ byte[] uDR;

    MsgRetransmitUI$12(MsgRetransmitUI msgRetransmitUI, String str, a aVar, byte[] bArr, bd bdVar) {
        this.uDL = msgRetransmitUI;
        this.bAd = str;
        this.uDQ = aVar;
        this.uDR = bArr;
        this.dAB = bdVar;
    }

    public final void run() {
        MsgRetransmitUI.a(this.uDL, this.bAd, this.uDQ, this.uDR, this.dAB);
    }
}
