package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;

class LoginIndepPass$16 implements OnCancelListener {
    final /* synthetic */ q eQM;
    final /* synthetic */ LoginIndepPass eRJ;

    LoginIndepPass$16(LoginIndepPass loginIndepPass, q qVar) {
        this.eRJ = loginIndepPass;
        this.eQM = qVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eQM);
    }
}
