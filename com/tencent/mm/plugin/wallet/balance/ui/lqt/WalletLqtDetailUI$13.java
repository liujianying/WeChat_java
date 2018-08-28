package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;

class WalletLqtDetailUI$13 implements OnClickListener {
    final /* synthetic */ WalletLqtDetailUI pbs;

    WalletLqtDetailUI$13(WalletLqtDetailUI walletLqtDetailUI) {
        this.pbs = walletLqtDetailUI;
    }

    public final void onClick(View view) {
        qu quVar = new qu();
        quVar.cbq.userName = WalletLqtDetailUI.c(this.pbs).sfI.username;
        quVar.cbq.cbs = bi.aG(WalletLqtDetailUI.c(this.pbs).sfI.path, "");
        quVar.cbq.scene = 1061;
        quVar.cbq.cbt = 0;
        a.sFg.m(quVar);
    }
}
