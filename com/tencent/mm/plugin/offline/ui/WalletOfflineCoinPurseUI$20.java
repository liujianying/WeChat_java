package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletOfflineCoinPurseUI$20 implements OnClickListener {
    final /* synthetic */ WalletOfflineCoinPurseUI lMe;

    WalletOfflineCoinPurseUI$20(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.lMe = walletOfflineCoinPurseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.lMe.finish();
    }
}
