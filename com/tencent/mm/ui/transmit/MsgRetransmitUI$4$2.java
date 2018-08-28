package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.4;

class MsgRetransmitUI$4$2 implements OnClickListener {
    final /* synthetic */ 4 uDM;

    MsgRetransmitUI$4$2(4 4) {
        this.uDM = 4;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (MsgRetransmitUI.b(this.uDM.uDL) != null) {
            MsgRetransmitUI.b(this.uDM.uDL).show();
        }
    }
}
