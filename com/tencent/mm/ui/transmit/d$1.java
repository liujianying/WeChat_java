package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.a;

class d$1 implements OnCancelListener {
    final /* synthetic */ a tMV;
    final /* synthetic */ d uEO;

    d$1(d dVar, a aVar) {
        this.uEO = dVar;
        this.tMV = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.tMV.uDV = true;
    }
}
