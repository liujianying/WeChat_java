package com.tencent.mm.ui.transmit;

class MsgRetransmitUI$15 implements Runnable {
    final /* synthetic */ MsgRetransmitUI uDL;

    MsgRetransmitUI$15(MsgRetransmitUI msgRetransmitUI) {
        this.uDL = msgRetransmitUI;
    }

    public final void run() {
        this.uDL.finish();
    }
}
