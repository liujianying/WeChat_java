package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.Orders.ShowInfo;
import com.tencent.mm.sdk.platformtools.x;

class WalletOrderInfoNewUI$19 implements OnClickListener {
    final /* synthetic */ WalletOrderInfoNewUI pwh;
    final /* synthetic */ ShowInfo pwi;

    WalletOrderInfoNewUI$19(WalletOrderInfoNewUI walletOrderInfoNewUI, ShowInfo showInfo) {
        this.pwh = walletOrderInfoNewUI;
        this.pwi = showInfo;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WalletOrderInfoNewUI", "onClick showInfo, jump url: %s", new Object[]{this.pwi.pqo});
        this.pwh.Ps(this.pwi.pqo);
    }
}
