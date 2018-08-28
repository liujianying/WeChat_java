package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class MsgRetransmitUI$13 implements OnClickListener {
    final /* synthetic */ String dhF;
    final /* synthetic */ MsgRetransmitUI uDL;

    MsgRetransmitUI$13(MsgRetransmitUI msgRetransmitUI, String str) {
        this.uDL = msgRetransmitUI;
        this.dhF = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        MsgRetransmitUI.a(this.uDL, this.uDL.getIntent(), this.dhF);
    }
}
