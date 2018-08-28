package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.wallet_core.ui.e;

class WalletBankcardDetailUI$1 implements OnClickListener {
    final /* synthetic */ WalletBankcardDetailUI pcX;

    WalletBankcardDetailUI$1(WalletBankcardDetailUI walletBankcardDetailUI) {
        this.pcX = walletBankcardDetailUI;
    }

    public final void onClick(View view) {
        e.l(this.pcX, this.pcX.paI.field_repay_url, false);
    }
}
