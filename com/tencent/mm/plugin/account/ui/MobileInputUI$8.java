package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class MobileInputUI$8 implements OnKeyListener {
    final /* synthetic */ MobileInputUI eTe;

    MobileInputUI$8(MobileInputUI mobileInputUI) {
        this.eTe = mobileInputUI;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (66 == i && keyEvent.getAction() == 0) {
            return MobileInputUI.f(this.eTe);
        }
        return false;
    }
}
