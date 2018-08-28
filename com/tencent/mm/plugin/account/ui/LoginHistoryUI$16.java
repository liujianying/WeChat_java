package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class LoginHistoryUI$16 implements OnDismissListener {
    final /* synthetic */ LoginHistoryUI eRA;

    LoginHistoryUI$16(LoginHistoryUI loginHistoryUI) {
        this.eRA = loginHistoryUI;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        LoginHistoryUI.j(this.eRA);
    }
}
