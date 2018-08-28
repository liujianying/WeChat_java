package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WalletBindCardResultUI$2 implements OnClickListener {
    final /* synthetic */ WalletBindCardResultUI ptz;

    WalletBindCardResultUI$2(WalletBindCardResultUI walletBindCardResultUI) {
        this.ptz = walletBindCardResultUI;
    }

    public final void onClick(View view) {
        this.ptz.done();
    }
}
