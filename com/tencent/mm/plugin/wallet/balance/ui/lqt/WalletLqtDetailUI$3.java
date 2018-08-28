package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.vending.g.g;

class WalletLqtDetailUI$3 implements OnClickListener {
    final /* synthetic */ WalletLqtDetailUI pbs;

    WalletLqtDetailUI$3(WalletLqtDetailUI walletLqtDetailUI) {
        this.pbs = walletLqtDetailUI;
    }

    public final void onClick(View view) {
        g.cx(Integer.valueOf(WalletLqtDetailUI.c(this.pbs).rtK)).c(WalletLqtDetailUI.f(this.pbs).oYW);
        Intent intent = new Intent(this.pbs, WalletLqtSaveFetchUI.class);
        intent.putExtra("lqt_save_fetch_mode", 2);
        intent.putExtra("lqt_balance", WalletLqtDetailUI.c(this.pbs).balance);
        intent.putExtra("lqt_max_redeem_amount", WalletLqtDetailUI.c(this.pbs).sfK);
        intent.putExtra("lqt_redeem_invalid_amount_hint", WalletLqtDetailUI.c(this.pbs).sfL);
        intent.putExtra("lqt_account_type", WalletLqtDetailUI.c(this.pbs).rtK);
        this.pbs.startActivity(intent);
    }
}
