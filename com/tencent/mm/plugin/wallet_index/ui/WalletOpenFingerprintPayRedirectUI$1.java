package com.tencent.mm.plugin.wallet_index.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class WalletOpenFingerprintPayRedirectUI$1 implements OnCancelListener {
    final /* synthetic */ WalletOpenFingerprintPayRedirectUI pDJ;

    WalletOpenFingerprintPayRedirectUI$1(WalletOpenFingerprintPayRedirectUI walletOpenFingerprintPayRedirectUI) {
        this.pDJ = walletOpenFingerprintPayRedirectUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        WalletOpenFingerprintPayRedirectUI.a(this.pDJ);
        WalletOpenFingerprintPayRedirectUI.a(this.pDJ, "");
    }
}
