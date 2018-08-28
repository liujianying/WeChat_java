package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.wallet_core.ui.e;

class WalletOrderInfoOldUI$10 implements OnClickListener {
    final /* synthetic */ WalletOrderInfoOldUI pwD;

    WalletOrderInfoOldUI$10(WalletOrderInfoOldUI walletOrderInfoOldUI) {
        this.pwD = walletOrderInfoOldUI;
    }

    public final void onClick(View view) {
        e.l(this.pwD, ((Commodity) this.pwD.pfb.ppf.get(0)).ppH.url, false);
    }
}
