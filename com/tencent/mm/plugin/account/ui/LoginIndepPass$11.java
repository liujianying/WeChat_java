package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class LoginIndepPass$11 implements OnEditorActionListener {
    final /* synthetic */ LoginIndepPass eRJ;

    LoginIndepPass$11(LoginIndepPass loginIndepPass) {
        this.eRJ = loginIndepPass;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 && i != 5) {
            return false;
        }
        LoginIndepPass.a(this.eRJ);
        return true;
    }
}
