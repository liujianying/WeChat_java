package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class LoginHistoryUI$22 implements OnClickListener {
    final /* synthetic */ LoginHistoryUI eRA;

    LoginHistoryUI$22(LoginHistoryUI loginHistoryUI) {
        this.eRA = loginHistoryUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.LoginHistoryUI", "db dangerous and auto logout");
        LoginHistoryUI.a(this.eRA);
    }
}
