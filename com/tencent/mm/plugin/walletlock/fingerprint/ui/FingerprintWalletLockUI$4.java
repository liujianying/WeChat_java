package com.tencent.mm.plugin.walletlock.fingerprint.ui;

class FingerprintWalletLockUI$4 implements Runnable {
    final /* synthetic */ FingerprintWalletLockUI pGT;

    FingerprintWalletLockUI$4(FingerprintWalletLockUI fingerprintWalletLockUI) {
        this.pGT = fingerprintWalletLockUI;
    }

    public final void run() {
        FingerprintWalletLockUI.h(this.pGT).setVisibility(0);
    }
}
