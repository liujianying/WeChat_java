package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;

class RegSetInfoUI$7 implements OnCancelListener {
    final /* synthetic */ RegSetInfoUI eWJ;
    final /* synthetic */ s eWK;

    RegSetInfoUI$7(RegSetInfoUI regSetInfoUI, s sVar) {
        this.eWJ = regSetInfoUI;
        this.eWK = sVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eWK);
        g.DF().b(126, this.eWJ);
    }
}
