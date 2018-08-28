package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.ui.base.h.c;

class WalletOrderInfoOldUI$9 implements c {
    final /* synthetic */ WalletOrderInfoOldUI pwD;

    WalletOrderInfoOldUI$9(WalletOrderInfoOldUI walletOrderInfoOldUI) {
        this.pwD = walletOrderInfoOldUI;
    }

    public final void ju(int i) {
        switch (i) {
            case 0:
                WalletOrderInfoOldUI.a(this.pwD, false);
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.pwD.lPn));
                intent.addFlags(268435456);
                this.pwD.startActivity(intent);
                return;
            default:
                return;
        }
    }
}
