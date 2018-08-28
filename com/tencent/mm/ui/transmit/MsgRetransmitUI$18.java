package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class MsgRetransmitUI$18 implements OnClickListener {
    final /* synthetic */ MsgRetransmitUI uDL;

    MsgRetransmitUI$18(MsgRetransmitUI msgRetransmitUI) {
        this.uDL = msgRetransmitUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.uDL.finish();
    }
}
