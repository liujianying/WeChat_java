package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import com.tencent.mm.plugin.walletlock.a.g;
import com.tencent.mm.plugin.walletlock.fingerprint.a.d.a;
import com.tencent.mm.sdk.platformtools.x;

class FingerprintWalletLockUI$8 implements a {
    final /* synthetic */ FingerprintWalletLockUI pGT;

    FingerprintWalletLockUI$8(FingerprintWalletLockUI fingerprintWalletLockUI) {
        this.pGT = fingerprintWalletLockUI;
    }

    public final void af(int i, String str) {
        x.i("MicroMsg.FingerprintWalletLockUI", "prepare onFinish errCode: %d, errMsg: %s, time: %d", new Object[]{Integer.valueOf(i), str, Long.valueOf(System.currentTimeMillis())});
        if (FingerprintWalletLockUI.c(this.pGT)) {
            x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo has cancelled and return");
        } else if (i == 0) {
            FingerprintWalletLockUI.f(this.pGT);
        } else {
            FingerprintWalletLockUI.b(this.pGT, this.pGT.getString(g.wallet_lock_fingerprint_system_error));
        }
    }
}
