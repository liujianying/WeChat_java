package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;

class WalletPayUSecurityQuestionAnswerUI$1 implements a {
    final /* synthetic */ WalletPayUSecurityQuestionAnswerUI pGp;

    WalletPayUSecurityQuestionAnswerUI$1(WalletPayUSecurityQuestionAnswerUI walletPayUSecurityQuestionAnswerUI) {
        this.pGp = walletPayUSecurityQuestionAnswerUI;
    }

    public final void fE(boolean z) {
        boolean z2;
        WalletPayUSecurityQuestionAnswerUI$a a = WalletPayUSecurityQuestionAnswerUI.a(this.pGp);
        if (WalletPayUSecurityQuestionAnswerUI.b(a.pGp).ZF()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            WalletPayUSecurityQuestionAnswerUI.c(a.pGp).setEnabled(true);
        } else {
            WalletPayUSecurityQuestionAnswerUI.c(a.pGp).setEnabled(false);
        }
    }
}
