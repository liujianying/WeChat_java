package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class LoginUI$8 implements OnEditorActionListener {
    final /* synthetic */ LoginUI eSk;

    LoginUI$8(LoginUI loginUI) {
        this.eSk = loginUI;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 && i != 5) {
            return false;
        }
        LoginUI.f(this.eSk);
        return true;
    }
}
