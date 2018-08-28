package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class SimpleLoginUI$17 implements OnKeyListener {
    final /* synthetic */ SimpleLoginUI eXn;

    SimpleLoginUI$17(SimpleLoginUI simpleLoginUI) {
        this.eXn = simpleLoginUI;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (66 != i || keyEvent.getAction() != 0) {
            return false;
        }
        SimpleLoginUI.b(this.eXn);
        return true;
    }
}
