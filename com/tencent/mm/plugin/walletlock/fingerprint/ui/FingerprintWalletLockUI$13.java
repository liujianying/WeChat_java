package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.sdk.platformtools.x;

class FingerprintWalletLockUI$13 implements OnClickListener {
    final /* synthetic */ FingerprintWalletLockUI pGT;

    FingerprintWalletLockUI$13(FingerprintWalletLockUI fingerprintWalletLockUI) {
        this.pGT = fingerprintWalletLockUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user click set gesture");
        ((b) g.l(b.class)).b(this.pGT, 1, 4);
    }
}
