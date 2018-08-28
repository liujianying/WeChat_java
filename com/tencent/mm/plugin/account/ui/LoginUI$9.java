package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class LoginUI$9 implements OnKeyListener {
    final /* synthetic */ LoginUI eSk;

    LoginUI$9(LoginUI loginUI) {
        this.eSk = loginUI;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (66 != i || keyEvent.getAction() != 0) {
            return false;
        }
        LoginUI.f(this.eSk);
        return true;
    }
}
