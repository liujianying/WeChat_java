package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mm.wallet_core.ui.e;

class WalletLqtDetailUI$10 implements OnClickListener {
    final /* synthetic */ WalletLqtDetailUI pbs;
    final /* synthetic */ LinearLayout pbw;

    WalletLqtDetailUI$10(WalletLqtDetailUI walletLqtDetailUI, LinearLayout linearLayout) {
        this.pbs = walletLqtDetailUI;
        this.pbw = linearLayout;
    }

    public final void onClick(View view) {
        e.l(this.pbs, (String) this.pbw.getTag(), false);
    }
}
