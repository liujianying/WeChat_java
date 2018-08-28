package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class RegSetInfoUI$2 implements OnKeyListener {
    final /* synthetic */ RegSetInfoUI eWJ;

    RegSetInfoUI$2(RegSetInfoUI regSetInfoUI) {
        this.eWJ = regSetInfoUI;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (66 != i || keyEvent.getAction() != 0) {
            return false;
        }
        RegSetInfoUI.p(this.eWJ);
        return true;
    }
}
