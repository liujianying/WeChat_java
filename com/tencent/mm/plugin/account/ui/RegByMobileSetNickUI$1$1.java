package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.plugin.account.ui.RegByMobileSetNickUI.1;

class RegByMobileSetNickUI$1$1 implements OnCancelListener {
    final /* synthetic */ s eVu;
    final /* synthetic */ 1 eVv;

    RegByMobileSetNickUI$1$1(1 1, s sVar) {
        this.eVv = 1;
        this.eVu = sVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eVu);
    }
}
