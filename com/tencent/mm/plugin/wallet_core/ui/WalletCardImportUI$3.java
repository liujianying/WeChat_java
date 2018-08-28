package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WalletCardImportUI$3 implements OnClickListener {
    final /* synthetic */ WalletCardImportUI puv;

    WalletCardImportUI$3(WalletCardImportUI walletCardImportUI) {
        this.puv = walletCardImportUI;
    }

    public final void onClick(View view) {
        this.puv.showDialog(1);
    }
}
