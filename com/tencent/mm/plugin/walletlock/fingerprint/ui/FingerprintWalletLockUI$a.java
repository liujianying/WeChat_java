package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import com.tencent.mm.plugin.walletlock.a$g;
import com.tencent.mm.plugin.walletlock.b.b;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public class FingerprintWalletLockUI$a implements b {
    private WeakReference<FingerprintWalletLockUI> jhv = null;
    final /* synthetic */ FingerprintWalletLockUI pGT;

    public FingerprintWalletLockUI$a(FingerprintWalletLockUI fingerprintWalletLockUI, FingerprintWalletLockUI fingerprintWalletLockUI2) {
        this.pGT = fingerprintWalletLockUI;
        this.jhv = new WeakReference(fingerprintWalletLockUI2);
    }

    private FingerprintWalletLockUI bRC() {
        if (this.jhv != null) {
            return (FingerprintWalletLockUI) this.jhv.get();
        }
        return null;
    }

    public final void bRD() {
        FingerprintWalletLockUI.a(this.pGT);
        FingerprintWalletLockUI.b(this.pGT);
    }

    public final void M(int i, String str) {
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onResult result: %d, errMsg: %s, isCancelled: %b", new Object[]{Integer.valueOf(i), str, Boolean.valueOf(FingerprintWalletLockUI.c(this.pGT))});
        if (!FingerprintWalletLockUI.c(this.pGT)) {
            switch (i) {
                case 0:
                    x.i("MicroMsg.FingerprintWalletLockUI", "identify success");
                    if (bRC() != null) {
                        FingerprintWalletLockUI.d(bRC());
                        return;
                    }
                    return;
                case 1:
                    x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify ERR_NO_MATCH");
                    if (bRC() != null) {
                        FingerprintWalletLockUI.a(bRC(), i, this.pGT.getString(a$g.wallet_lock_fingerprint_verify_not_match_error));
                        return;
                    }
                    return;
                case 2:
                    if (bRC() != null) {
                        FingerprintWalletLockUI.b(bRC(), i, this.pGT.getString(a$g.wallet_lock_fingerprint_system_error));
                        return;
                    }
                    return;
                case 3:
                    x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo on error: %d", new Object[]{Integer.valueOf(i)});
                    if (bRC() != null) {
                        FingerprintWalletLockUI.b(bRC(), i, this.pGT.getString(a$g.wallet_lock_fingerprint_too_many_trial_error));
                        return;
                    }
                    return;
                case 4:
                    x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user cancel");
                    return;
                case 5:
                    x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify TIMEOUT");
                    if (bRC() != null) {
                        FingerprintWalletLockUI.a(bRC(), i, this.pGT.getString(a$g.wallet_lock_fingerprint_verify_not_match_error));
                        return;
                    }
                    return;
                case 8:
                    if (bRC() != null) {
                        FingerprintWalletLockUI.b(bRC(), i, this.pGT.getString(a$g.wallet_lock_no_fingerprint_when_offline_verify));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
