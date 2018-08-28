package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class MsgRetransmitUI$14 implements OnClickListener {
    final /* synthetic */ MsgRetransmitUI uDL;

    MsgRetransmitUI$14(MsgRetransmitUI msgRetransmitUI) {
        this.uDL = msgRetransmitUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.uDL.finish();
    }
}
