package com.tencent.mm.plugin.wallet_index.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletOpenFingerprintPayRedirectUI$2 implements OnClickListener {
    final /* synthetic */ WalletOpenFingerprintPayRedirectUI pDJ;

    WalletOpenFingerprintPayRedirectUI$2(WalletOpenFingerprintPayRedirectUI walletOpenFingerprintPayRedirectUI) {
        this.pDJ = walletOpenFingerprintPayRedirectUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pDJ.finish();
    }
}
