package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI;
import com.tencent.mm.storage.aa.a;

class WalletBalanceManagerUI$14 implements OnClickListener {
    final /* synthetic */ WalletBalanceManagerUI pax;

    WalletBalanceManagerUI$14(WalletBalanceManagerUI walletBalanceManagerUI) {
        this.pax = walletBalanceManagerUI;
    }

    public final void onClick(View view) {
        g.Ek();
        g.Ei().DT().a(a.sXO, Integer.valueOf(-1));
        Intent intent = new Intent(this.pax, WalletLqtDetailUI.class);
        intent.putExtra("key_account_type", 1);
        this.pax.startActivity(intent);
    }
}
