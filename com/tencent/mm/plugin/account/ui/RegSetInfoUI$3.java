package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class RegSetInfoUI$3 implements OnEditorActionListener {
    final /* synthetic */ RegSetInfoUI eWJ;

    RegSetInfoUI$3(RegSetInfoUI regSetInfoUI) {
        this.eWJ = regSetInfoUI;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 && i != 5) {
            return false;
        }
        RegSetInfoUI.p(this.eWJ);
        return true;
    }
}
