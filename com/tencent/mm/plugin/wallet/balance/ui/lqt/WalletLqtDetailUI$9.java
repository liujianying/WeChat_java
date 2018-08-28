package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.e;

class WalletLqtDetailUI$9 implements OnClickListener {
    final /* synthetic */ WalletLqtDetailUI pbs;

    WalletLqtDetailUI$9(WalletLqtDetailUI walletLqtDetailUI) {
        this.pbs = walletLqtDetailUI;
    }

    public final void onClick(View view) {
        if (!bi.oW(WalletLqtDetailUI.c(this.pbs).sfP)) {
            e.l(this.pbs, WalletLqtDetailUI.c(this.pbs).sfP, false);
        }
    }
}
