package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.sdk.platformtools.w;

class LoginHistoryUI$27 implements OnClickListener {
    final /* synthetic */ LoginHistoryUI eRA;

    LoginHistoryUI$27(LoginHistoryUI loginHistoryUI) {
        this.eRA = loginHistoryUI;
    }

    public final void onClick(View view) {
        LoginHistoryUI.P(this.eRA, this.eRA.getString(j.freeze_account_url, new Object[]{w.chP()}));
    }
}
