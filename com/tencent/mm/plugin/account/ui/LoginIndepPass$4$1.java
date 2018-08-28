package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.plugin.account.ui.LoginIndepPass.4;

class LoginIndepPass$4$1 implements OnCancelListener {
    final /* synthetic */ q eQM;
    final /* synthetic */ 4 eRK;

    LoginIndepPass$4$1(4 4, q qVar) {
        this.eRK = 4;
        this.eQM = qVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eQM);
        g.DF().b(701, this.eRK.eRJ);
    }
}
