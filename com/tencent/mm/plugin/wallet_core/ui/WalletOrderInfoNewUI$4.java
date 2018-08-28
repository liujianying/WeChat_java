package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class WalletOrderInfoNewUI$4 implements OnClickListener {
    final /* synthetic */ WalletOrderInfoNewUI pwh;

    WalletOrderInfoNewUI$4(WalletOrderInfoNewUI walletOrderInfoNewUI) {
        this.pwh = walletOrderInfoNewUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WalletOrderInfoNewUI", "click activity layout");
        WalletOrderInfoNewUI.p(this.pwh);
    }
}
