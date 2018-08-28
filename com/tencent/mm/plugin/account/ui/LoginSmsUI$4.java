package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;

class LoginSmsUI$4 implements OnCancelListener {
    final /* synthetic */ a eRM;
    final /* synthetic */ LoginSmsUI eRV;

    LoginSmsUI$4(LoginSmsUI loginSmsUI, a aVar) {
        this.eRV = loginSmsUI;
        this.eRM = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eRM);
    }
}
