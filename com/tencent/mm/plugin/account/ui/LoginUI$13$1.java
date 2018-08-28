package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.plugin.account.ui.LoginUI.13;

class LoginUI$13$1 implements OnCancelListener {
    final /* synthetic */ q eQM;
    final /* synthetic */ 13 eSl;

    LoginUI$13$1(13 13, q qVar) {
        this.eSl = 13;
        this.eQM = qVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eQM);
        g.DF().b(701, this.eSl.eSk);
    }
}
