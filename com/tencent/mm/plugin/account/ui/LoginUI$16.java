package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class LoginUI$16 implements OnCancelListener {
    final /* synthetic */ LoginUI eSk;

    LoginUI$16(LoginUI loginUI) {
        this.eSk = loginUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        LoginUI.l(this.eSk);
    }
}
