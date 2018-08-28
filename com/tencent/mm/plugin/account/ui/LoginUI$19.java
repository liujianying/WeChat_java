package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;

class LoginUI$19 implements OnCancelListener {
    final /* synthetic */ q eQM;
    final /* synthetic */ LoginUI eSk;

    LoginUI$19(LoginUI loginUI, q qVar) {
        this.eSk = loginUI;
        this.eQM = qVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eQM);
        g.DF().b(701, this.eSk);
    }
}
