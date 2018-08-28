package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.MMScrollView.b;

class WalletCardImportUI$1 implements b {
    final /* synthetic */ WalletCardImportUI puv;

    WalletCardImportUI$1(WalletCardImportUI walletCardImportUI) {
        this.puv = walletCardImportUI;
    }

    public final void jv(boolean z) {
        int i = z ? 8 : 0;
        x.d("MicroMsg.WalletCardElmentUI", "onSizeChanged : " + z);
        WalletCardImportUI.b(this.puv).post(new 1(this, i));
    }
}
