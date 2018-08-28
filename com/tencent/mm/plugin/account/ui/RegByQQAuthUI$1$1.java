package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.plugin.account.ui.RegByQQAuthUI.1;

class RegByQQAuthUI$1$1 implements OnCancelListener {
    final /* synthetic */ s eWh;
    final /* synthetic */ 1 eWi;

    RegByQQAuthUI$1$1(1 1, s sVar) {
        this.eWi = 1;
        this.eWh = sVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eWh);
    }
}
