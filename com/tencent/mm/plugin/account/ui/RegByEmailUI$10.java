package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class RegByEmailUI$10 implements OnEditorActionListener {
    final /* synthetic */ RegByEmailUI eUG;

    RegByEmailUI$10(RegByEmailUI regByEmailUI) {
        this.eUG = regByEmailUI;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if ((i != 6 && i != 5) || !RegByEmailUI.d(this.eUG).isChecked()) {
            return false;
        }
        RegByEmailUI.c(this.eUG);
        return true;
    }
}
