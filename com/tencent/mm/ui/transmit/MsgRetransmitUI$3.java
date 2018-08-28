package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class MsgRetransmitUI$3 implements OnClickListener {
    final /* synthetic */ MsgRetransmitUI uDL;

    MsgRetransmitUI$3(MsgRetransmitUI msgRetransmitUI) {
        this.uDL = msgRetransmitUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (MsgRetransmitUI.b(this.uDL) != null) {
            MsgRetransmitUI.b(this.uDL).cancel();
        }
    }
}
