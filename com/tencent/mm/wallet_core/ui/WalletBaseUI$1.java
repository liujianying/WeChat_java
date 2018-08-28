package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.wallet_core.a;

class WalletBaseUI$1 implements OnClickListener {
    final /* synthetic */ WalletBaseUI uYT;

    WalletBaseUI$1(WalletBaseUI walletBaseUI) {
        this.uYT = walletBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        a.c(this.uYT, null, -10000);
    }
}
