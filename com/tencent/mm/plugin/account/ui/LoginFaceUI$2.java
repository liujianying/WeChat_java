package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;

class LoginFaceUI$2 implements OnCancelListener {
    final /* synthetic */ LoginFaceUI eQL;
    final /* synthetic */ q eQM;

    LoginFaceUI$2(LoginFaceUI loginFaceUI, q qVar) {
        this.eQL = loginFaceUI;
        this.eQM = qVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eQM);
        this.eQL.YB();
    }
}
