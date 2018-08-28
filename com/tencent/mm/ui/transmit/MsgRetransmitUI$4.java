package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class MsgRetransmitUI$4 implements OnCancelListener {
    final /* synthetic */ MsgRetransmitUI uDL;

    MsgRetransmitUI$4(MsgRetransmitUI msgRetransmitUI) {
        this.uDL = msgRetransmitUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        h.a(this.uDL, R.l.msgretr_cancel_confirm, R.l.app_tip, R.l.app_yes, R.l.app_no, new 1(this), new 2(this));
    }
}
