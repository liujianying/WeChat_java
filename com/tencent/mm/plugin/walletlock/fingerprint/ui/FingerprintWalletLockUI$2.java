package com.tencent.mm.plugin.walletlock.fingerprint.ui;

class FingerprintWalletLockUI$2 implements Runnable {
    final /* synthetic */ FingerprintWalletLockUI pGT;

    FingerprintWalletLockUI$2(FingerprintWalletLockUI fingerprintWalletLockUI) {
        this.pGT = fingerprintWalletLockUI;
    }

    public final void run() {
        this.pGT.finish();
    }
}
