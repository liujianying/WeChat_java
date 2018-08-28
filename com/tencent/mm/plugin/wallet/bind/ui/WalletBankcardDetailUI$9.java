package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletBankcardDetailUI$9 implements OnClickListener {
    final /* synthetic */ int gVI;
    final /* synthetic */ WalletBankcardDetailUI pcX;

    WalletBankcardDetailUI$9(WalletBankcardDetailUI walletBankcardDetailUI, int i) {
        this.pcX = walletBankcardDetailUI;
        this.gVI = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.gVI == 2) {
            WalletBankcardDetailUI.b(this.pcX);
        }
        dialogInterface.dismiss();
    }
}
