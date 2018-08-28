package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h.c;

class WalletBankcardDetailUI$8 implements c {
    final /* synthetic */ WalletBankcardDetailUI pcX;

    WalletBankcardDetailUI$8(WalletBankcardDetailUI walletBankcardDetailUI) {
        this.pcX = walletBankcardDetailUI;
    }

    public final void ju(int i) {
        switch (i) {
            case 0:
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.pcX.getString(i.wallet_bankcard_detail_bankphone_number)));
                intent.addFlags(268435456);
                this.pcX.startActivity(intent);
                return;
            default:
                return;
        }
    }
}
