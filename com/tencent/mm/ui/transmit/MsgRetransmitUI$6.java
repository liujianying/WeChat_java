package com.tencent.mm.ui.transmit;

import com.tencent.mm.pluginsdk.model.j.a;

class MsgRetransmitUI$6 implements a {
    final /* synthetic */ MsgRetransmitUI uDL;

    MsgRetransmitUI$6(MsgRetransmitUI msgRetransmitUI) {
        this.uDL = msgRetransmitUI;
    }

    public final void cbw() {
        if (MsgRetransmitUI.f(this.uDL) != null) {
            MsgRetransmitUI.f(this.uDL).dismiss();
            MsgRetransmitUI.g(this.uDL);
        }
        this.uDL.finish();
    }
}
