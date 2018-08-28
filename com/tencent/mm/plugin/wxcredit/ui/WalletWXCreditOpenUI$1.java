package com.tencent.mm.plugin.wxcredit.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class WalletWXCreditOpenUI$1 implements OnCheckedChangeListener {
    final /* synthetic */ WalletWXCreditOpenUI qxy;

    WalletWXCreditOpenUI$1(WalletWXCreditOpenUI walletWXCreditOpenUI) {
        this.qxy = walletWXCreditOpenUI;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        WalletWXCreditOpenUI.a(this.qxy).setEnabled(z);
    }
}
