package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.plugin.account.ui.RegSetInfoUI.10;

class RegSetInfoUI$10$1 implements OnCancelListener {
    final /* synthetic */ s eTB;
    final /* synthetic */ 10 eWL;

    RegSetInfoUI$10$1(10 10, s sVar) {
        this.eWL = 10;
        this.eTB = sVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eTB);
        g.DF().b(126, this.eWL.eWJ);
    }
}
