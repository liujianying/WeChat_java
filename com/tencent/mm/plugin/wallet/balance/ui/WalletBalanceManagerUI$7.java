package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.wallet_core.ui.e;

class WalletBalanceManagerUI$7 implements OnClickListener {
    final /* synthetic */ WalletBalanceManagerUI pax;

    WalletBalanceManagerUI$7(WalletBalanceManagerUI walletBalanceManagerUI) {
        this.pax = walletBalanceManagerUI;
    }

    public final void onClick(View view) {
        this.pax.bMW();
        e.He(14);
    }
}
