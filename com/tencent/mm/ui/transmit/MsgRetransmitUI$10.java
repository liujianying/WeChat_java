package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.a;

class MsgRetransmitUI$10 implements OnCancelListener {
    final /* synthetic */ a tMV;
    final /* synthetic */ MsgRetransmitUI uDL;

    MsgRetransmitUI$10(MsgRetransmitUI msgRetransmitUI, a aVar) {
        this.uDL = msgRetransmitUI;
        this.tMV = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.tMV.uDV = true;
    }
}
