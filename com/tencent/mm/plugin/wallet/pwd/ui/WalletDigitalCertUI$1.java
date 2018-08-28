package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.view.View;
import com.tencent.mm.wallet_core.ui.d;

class WalletDigitalCertUI$1 extends d {
    final /* synthetic */ WalletDigitalCertUI phy;

    WalletDigitalCertUI$1(WalletDigitalCertUI walletDigitalCertUI) {
        this.phy = walletDigitalCertUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.phy, WalletIdCardCheckUI.class);
        this.phy.startActivityForResult(intent, 1);
    }
}
