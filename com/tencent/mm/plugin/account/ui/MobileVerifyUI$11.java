package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class MobileVerifyUI$11 implements OnKeyListener {
    final /* synthetic */ MobileVerifyUI eUo;

    MobileVerifyUI$11(MobileVerifyUI mobileVerifyUI) {
        this.eUo = mobileVerifyUI;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (66 != i || keyEvent.getAction() != 0) {
            return false;
        }
        MobileVerifyUI.e(this.eUo);
        return true;
    }
}
