package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;

class LoginPasswordUI$6 implements OnCancelListener {
    final /* synthetic */ q eQM;
    final /* synthetic */ LoginPasswordUI eRO;

    LoginPasswordUI$6(LoginPasswordUI loginPasswordUI, q qVar) {
        this.eRO = loginPasswordUI;
        this.eQM = qVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eQM);
        this.eRO.YB();
    }
}
