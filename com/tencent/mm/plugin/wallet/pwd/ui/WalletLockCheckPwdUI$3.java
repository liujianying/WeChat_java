package com.tencent.mm.plugin.wallet.pwd.ui;

import com.tencent.mm.plugin.wallet.pwd.a.i;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

class WalletLockCheckPwdUI$3 implements a {
    final /* synthetic */ WalletLockCheckPwdUI phU;

    WalletLockCheckPwdUI$3(WalletLockCheckPwdUI walletLockCheckPwdUI) {
        this.phU = walletLockCheckPwdUI;
    }

    public final void fE(boolean z) {
        int i = 8;
        if (z && WalletLockCheckPwdUI.b(this.phU) != null) {
            if (WalletLockCheckPwdUI.b(this.phU).equals("action.close_wallet_lock")) {
                WalletLockCheckPwdUI.c(this.phU);
            } else if (WalletLockCheckPwdUI.b(this.phU).equals("action.verify_paypwd")) {
                if (WalletLockCheckPwdUI.d(this.phU) == 1) {
                    i = 6;
                } else if (WalletLockCheckPwdUI.d(this.phU) != 2) {
                    i = -1;
                }
                WalletLockCheckPwdUI.a(this.phU, new r(WalletLockCheckPwdUI.e(this.phU).getText(), i, this.phU.bNs()));
                this.phU.a(WalletLockCheckPwdUI.f(this.phU), true, false);
            } else if (WalletLockCheckPwdUI.b(this.phU).equals("action.touchlock_verify_by_paypwd")) {
                this.phU.a(new i(WalletLockCheckPwdUI.e(this.phU).getText()), true, false);
            } else if (WalletLockCheckPwdUI.b(this.phU).equals("action.touchlock_need_verify_paypwd")) {
                if (WalletLockCheckPwdUI.d(this.phU) != 2) {
                    i = -1;
                }
                WalletLockCheckPwdUI.a(this.phU, new r(WalletLockCheckPwdUI.e(this.phU).getText(), i, this.phU.bNs()));
                this.phU.a(WalletLockCheckPwdUI.f(this.phU), true, false);
            }
        }
    }
}
