package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class LoginPasswordUI$1 implements OnEditorActionListener {
    final /* synthetic */ LoginPasswordUI eRO;

    LoginPasswordUI$1(LoginPasswordUI loginPasswordUI) {
        this.eRO = loginPasswordUI;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 && i != 5) {
            return false;
        }
        this.eRO.Yz();
        return true;
    }
}
