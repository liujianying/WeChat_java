package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class MobileInputUI$7 implements OnEditorActionListener {
    final /* synthetic */ MobileInputUI eTe;

    MobileInputUI$7(MobileInputUI mobileInputUI) {
        this.eTe = mobileInputUI;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6 || i == 5) {
            return MobileInputUI.f(this.eTe);
        }
        return false;
    }
}
