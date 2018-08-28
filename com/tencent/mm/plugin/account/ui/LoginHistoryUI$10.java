package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.r;

class LoginHistoryUI$10 implements OnCancelListener {
    final /* synthetic */ LoginHistoryUI eRA;
    final /* synthetic */ r eRC;

    LoginHistoryUI$10(LoginHistoryUI loginHistoryUI, r rVar) {
        this.eRA = loginHistoryUI;
        this.eRC = rVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eRC);
        g.DF().b(255, this.eRA);
    }
}
