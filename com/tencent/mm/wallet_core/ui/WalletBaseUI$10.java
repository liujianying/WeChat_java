package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class WalletBaseUI$10 implements OnCancelListener {
    final /* synthetic */ WalletBaseUI uYT;

    WalletBaseUI$10(WalletBaseUI walletBaseUI) {
        this.uYT = walletBaseUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.uYT.baT();
    }
}
