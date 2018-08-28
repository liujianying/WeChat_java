package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import android.view.View;
import android.view.View.OnClickListener;

class FingerprintWalletLockUI$7 implements OnClickListener {
    final /* synthetic */ FingerprintWalletLockUI pGT;

    FingerprintWalletLockUI$7(FingerprintWalletLockUI fingerprintWalletLockUI) {
        this.pGT = fingerprintWalletLockUI;
    }

    public final void onClick(View view) {
        FingerprintWalletLockUI.bRB();
        FingerprintWalletLockUI.a(this.pGT, "user cancel setting fingerprint lock");
    }
}
