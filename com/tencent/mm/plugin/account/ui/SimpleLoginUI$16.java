package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class SimpleLoginUI$16 implements OnEditorActionListener {
    final /* synthetic */ SimpleLoginUI eXn;

    SimpleLoginUI$16(SimpleLoginUI simpleLoginUI) {
        this.eXn = simpleLoginUI;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 && i != 5) {
            return false;
        }
        SimpleLoginUI.b(this.eXn);
        return true;
    }
}
