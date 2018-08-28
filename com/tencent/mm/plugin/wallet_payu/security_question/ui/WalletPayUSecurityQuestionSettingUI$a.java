package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import com.tencent.mm.sdk.platformtools.bi;

protected class WalletPayUSecurityQuestionSettingUI$a {
    final /* synthetic */ WalletPayUSecurityQuestionSettingUI pGt;

    protected WalletPayUSecurityQuestionSettingUI$a(WalletPayUSecurityQuestionSettingUI walletPayUSecurityQuestionSettingUI) {
        this.pGt = walletPayUSecurityQuestionSettingUI;
    }

    static /* synthetic */ void a(WalletPayUSecurityQuestionSettingUI$a walletPayUSecurityQuestionSettingUI$a) {
        if (walletPayUSecurityQuestionSettingUI$a.bRn()) {
            WalletPayUSecurityQuestionSettingUI.g(walletPayUSecurityQuestionSettingUI$a.pGt).setEnabled(true);
        } else {
            WalletPayUSecurityQuestionSettingUI.g(walletPayUSecurityQuestionSettingUI$a.pGt).setEnabled(false);
        }
    }

    protected final boolean bRn() {
        boolean z;
        if (bi.oW(WalletPayUSecurityQuestionSettingUI.b(this.pGt).pGw)) {
            z = false;
        } else {
            z = true;
        }
        return z && WalletPayUSecurityQuestionSettingUI.c(this.pGt).ZF();
    }
}
