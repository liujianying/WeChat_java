package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class FingerprintWalletLockUI$11 implements OnClickListener {
    final /* synthetic */ FingerprintWalletLockUI pGT;

    FingerprintWalletLockUI$11(FingerprintWalletLockUI fingerprintWalletLockUI) {
        this.pGT = fingerprintWalletLockUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pGT.finish();
        FingerprintWalletLockUI.bRB();
    }
}
