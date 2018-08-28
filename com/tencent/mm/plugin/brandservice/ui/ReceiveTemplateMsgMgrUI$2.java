package com.tencent.mm.plugin.brandservice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.d;

class ReceiveTemplateMsgMgrUI$2 implements OnCancelListener {
    final /* synthetic */ ReceiveTemplateMsgMgrUI hpP;
    final /* synthetic */ d hpQ;

    ReceiveTemplateMsgMgrUI$2(ReceiveTemplateMsgMgrUI receiveTemplateMsgMgrUI, d dVar) {
        this.hpP = receiveTemplateMsgMgrUI;
        this.hpQ = dVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.hpQ);
    }
}
