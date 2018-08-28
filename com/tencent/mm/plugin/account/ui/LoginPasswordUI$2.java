package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class LoginPasswordUI$2 implements OnKeyListener {
    final /* synthetic */ LoginPasswordUI eRO;

    LoginPasswordUI$2(LoginPasswordUI loginPasswordUI) {
        this.eRO = loginPasswordUI;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (66 != i || keyEvent.getAction() != 0) {
            return false;
        }
        this.eRO.Yz();
        return true;
    }
}
