package com.tencent.mm.plugin.wallet_core.id_verify;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class WalletRealNameVerifyUI$5 implements OnCheckedChangeListener {
    final /* synthetic */ WalletRealNameVerifyUI pkE;

    WalletRealNameVerifyUI$5(WalletRealNameVerifyUI walletRealNameVerifyUI) {
        this.pkE = walletRealNameVerifyUI;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            WalletRealNameVerifyUI.d(this.pkE).setEnabled(true);
            WalletRealNameVerifyUI.d(this.pkE).setClickable(true);
            return;
        }
        WalletRealNameVerifyUI.d(this.pkE).setEnabled(false);
        WalletRealNameVerifyUI.d(this.pkE).setClickable(false);
    }
}
