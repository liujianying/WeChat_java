package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.e;

class WalletLqtDetailUI$8 implements OnClickListener {
    final /* synthetic */ WalletLqtDetailUI pbs;

    WalletLqtDetailUI$8(WalletLqtDetailUI walletLqtDetailUI) {
        this.pbs = walletLqtDetailUI;
    }

    public final void onClick(View view) {
        if (!bi.oW(WalletLqtDetailUI.c(this.pbs).sfO)) {
            e.l(this.pbs, WalletLqtDetailUI.c(this.pbs).sfO, false);
        }
    }
}
