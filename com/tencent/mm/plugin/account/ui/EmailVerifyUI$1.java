package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.ui.base.MMAutoSwitchEditTextView.a;

class EmailVerifyUI$1 implements a {
    final /* synthetic */ EmailVerifyUI ePX;

    EmailVerifyUI$1(EmailVerifyUI emailVerifyUI) {
        this.ePX = emailVerifyUI;
    }

    public final void pJ(String str) {
        this.ePX.enableOptionMenu(true);
        EmailVerifyUI.a(this.ePX, str);
    }
}
