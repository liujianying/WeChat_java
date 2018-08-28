package com.tencent.mm.ui.transmit;

class MsgRetransmitUI$5 implements Runnable {
    final /* synthetic */ MsgRetransmitUI uDL;

    MsgRetransmitUI$5(MsgRetransmitUI msgRetransmitUI) {
        this.uDL = msgRetransmitUI;
    }

    public final void run() {
        this.uDL.finish();
    }
}
