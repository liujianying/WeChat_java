package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.pluginsdk.model.j;

class MsgRetransmitUI$7 implements OnCancelListener {
    final /* synthetic */ j tTg;
    final /* synthetic */ MsgRetransmitUI uDL;

    MsgRetransmitUI$7(MsgRetransmitUI msgRetransmitUI, j jVar) {
        this.uDL = msgRetransmitUI;
        this.tTg = jVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.tTg.cbu();
        this.uDL.uDK = true;
        this.uDL.finish();
    }
}
