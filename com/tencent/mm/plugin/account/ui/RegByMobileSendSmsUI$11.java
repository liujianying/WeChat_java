package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;

class RegByMobileSendSmsUI$11 implements OnCancelListener {
    final /* synthetic */ s eTB;
    final /* synthetic */ RegByMobileSendSmsUI eVm;

    RegByMobileSendSmsUI$11(RegByMobileSendSmsUI regByMobileSendSmsUI, s sVar) {
        this.eVm = regByMobileSendSmsUI;
        this.eTB = sVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eTB);
        g.DF().b(126, this.eVm);
    }
}
