package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.plugin.account.ui.LoginHistoryUI.15;

class LoginHistoryUI$15$1 implements OnCancelListener {
    final /* synthetic */ q eQM;
    final /* synthetic */ 15 eRD;

    LoginHistoryUI$15$1(15 15, q qVar) {
        this.eRD = 15;
        this.eQM = qVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eQM);
        g.DF().b(701, this.eRD.eRA);
    }
}
