package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.sdk.platformtools.x;

class FingerprintWalletLockUI$14 implements OnClickListener {
    final /* synthetic */ FingerprintWalletLockUI pGT;

    FingerprintWalletLockUI$14(FingerprintWalletLockUI fingerprintWalletLockUI) {
        this.pGT = fingerprintWalletLockUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user click close wallet lock");
        ((b) g.l(b.class)).i(this.pGT, 5);
    }
}
