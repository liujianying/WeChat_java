package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class FingerprintWalletLockUI$3 implements OnClickListener {
    final /* synthetic */ FingerprintWalletLockUI pGT;

    FingerprintWalletLockUI$3(FingerprintWalletLockUI fingerprintWalletLockUI) {
        this.pGT = fingerprintWalletLockUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pGT.finish();
    }
}
