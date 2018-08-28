package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.plugin.account.ui.RegSetInfoUI.15;

class RegSetInfoUI$15$1 implements OnCancelListener {
    final /* synthetic */ ad eWM;
    final /* synthetic */ 15 eWN;

    RegSetInfoUI$15$1(15 15, ad adVar) {
        this.eWN = 15;
        this.eWM = adVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eWM);
        g.DF().b(429, this.eWN.eWJ);
    }
}
