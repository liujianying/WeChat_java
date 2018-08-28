package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.m;
import java.util.List;

class LoginHistoryUI$24 implements OnClickListener {
    final /* synthetic */ LoginHistoryUI eRA;
    final /* synthetic */ List eRE;

    LoginHistoryUI$24(LoginHistoryUI loginHistoryUI, List list) {
        this.eRA = loginHistoryUI;
        this.eRE = list;
    }

    public final void onClick(View view) {
        LoginHistoryUI.a(this.eRA, ((m) this.eRE.get(0)).getItemId());
    }
}
