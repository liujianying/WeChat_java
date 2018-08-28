package com.tencent.mm.plugin.wallet_core.ui;

import android.text.Editable;
import android.text.TextWatcher;

class WalletBankcardIdUI$6 implements TextWatcher {
    final /* synthetic */ WalletBankcardIdUI psW;

    WalletBankcardIdUI$6(WalletBankcardIdUI walletBankcardIdUI) {
        this.psW = walletBankcardIdUI;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.psW.psQ.ZF() && !WalletBankcardIdUI.b(this.psW)) {
            WalletBankcardIdUI.c(this.psW);
            this.psW.psQ.bqn();
        }
    }

    public final void afterTextChanged(Editable editable) {
    }
}
