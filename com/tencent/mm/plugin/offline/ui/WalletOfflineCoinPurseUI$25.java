package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.offline.c.a;

class WalletOfflineCoinPurseUI$25 implements OnClickListener {
    final /* synthetic */ WalletOfflineCoinPurseUI lMe;

    WalletOfflineCoinPurseUI$25(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.lMe = walletOfflineCoinPurseUI;
    }

    public final void onClick(View view) {
        a.blJ();
        a.g(this.lMe, WalletOfflineCoinPurseUI.c(this.lMe));
        this.lMe.finish();
    }
}
