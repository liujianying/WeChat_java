package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bi;

class WalletOrderInfoNewUI$18 implements OnClickListener {
    final /* synthetic */ WalletOrderInfoNewUI pwh;

    WalletOrderInfoNewUI$18(WalletOrderInfoNewUI walletOrderInfoNewUI) {
        this.pwh = walletOrderInfoNewUI;
    }

    public final void onClick(View view) {
        if (!bi.oW(WalletOrderInfoNewUI.j(this.pwh))) {
            if (this.pwh.pvK.contains(WalletOrderInfoNewUI.j(this.pwh))) {
                this.pwh.pvK.remove(WalletOrderInfoNewUI.j(this.pwh));
                WalletOrderInfoNewUI.k(this.pwh).setChecked(false);
                return;
            }
            this.pwh.pvK.add(WalletOrderInfoNewUI.j(this.pwh));
            WalletOrderInfoNewUI.k(this.pwh).setChecked(true);
        }
    }
}
