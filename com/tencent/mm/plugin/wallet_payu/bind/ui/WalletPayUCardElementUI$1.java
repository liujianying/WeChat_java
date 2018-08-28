package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.text.Editable;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI.a;

class WalletPayUCardElementUI$1 extends a {
    final /* synthetic */ WalletPayUCardElementUI pEt;

    WalletPayUCardElementUI$1(WalletPayUCardElementUI walletPayUCardElementUI) {
        this.pEt = walletPayUCardElementUI;
        super(walletPayUCardElementUI, (byte) 0);
    }

    public final void afterTextChanged(Editable editable) {
        WalletPayUCardElementUI.a(this.pEt, WalletPayUCardElementUI.a(this.pEt), editable);
    }
}
