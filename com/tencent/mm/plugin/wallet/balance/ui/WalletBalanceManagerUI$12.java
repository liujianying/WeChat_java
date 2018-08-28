package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI;

class WalletBalanceManagerUI$12 implements OnClickListener {
    final /* synthetic */ WalletBalanceManagerUI pax;

    WalletBalanceManagerUI$12(WalletBalanceManagerUI walletBalanceManagerUI) {
        this.pax = walletBalanceManagerUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.pax, WalletLqtDetailUI.class);
        intent.putExtra("key_account_type", 1);
        this.pax.startActivity(intent);
    }
}
