package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class WalletOfflineCoinPurseUI$16 implements OnCancelListener {
    final /* synthetic */ WalletOfflineCoinPurseUI lMe;

    WalletOfflineCoinPurseUI$16(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.lMe = walletOfflineCoinPurseUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        WalletOfflineCoinPurseUI.B(this.lMe);
    }
}
