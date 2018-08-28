package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;

class WalletBankcardIdUI$4 implements h$a {
    final /* synthetic */ WalletBankcardIdUI psW;

    WalletBankcardIdUI$4(WalletBankcardIdUI walletBankcardIdUI) {
        this.psW = walletBankcardIdUI;
    }

    public final void onClick(View view) {
        x.i("Micromsg.WalletInputCardIDUI", "hy: clickable span on click");
        WalletBankcardIdUI.a(this.psW);
    }
}
