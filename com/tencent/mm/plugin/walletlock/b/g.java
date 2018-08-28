package com.tencent.mm.plugin.walletlock.b;

import com.tencent.d.a.c.i;
import com.tencent.mm.plugin.soter.c.h;
import com.tencent.mm.plugin.walletlock.gesture.a.b;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

public enum g {
    ;
    
    int mType;
    public String pIu;
    public i pIv;

    private g(String str) {
        this.mType = -1;
    }

    public final void zB(int i) {
        x.i("MicroMsg.WalletLockManager", "alvinluo old wallet lock type: %d, new type: %d", new Object[]{Integer.valueOf(this.mType), Integer.valueOf(i)});
        this.mType = i;
        com.tencent.mm.kernel.g.Ei().DT().a(a.sYz, Integer.valueOf(i));
        com.tencent.mm.kernel.g.Ei().DT().lm(true);
    }

    public final int bRY() {
        if (this.mType == -1) {
            this.mType = ((Integer) com.tencent.mm.kernel.g.Ei().DT().get(a.sYz, Integer.valueOf(0))).intValue();
        }
        return this.mType;
    }

    public static boolean bRE() {
        return b.bRE();
    }

    public static void jI(boolean z) {
        x.i("MicroMsg.GestureGuardManager", "alvinluo setUserSetGesturePwd: %b", new Object[]{Boolean.valueOf(z)});
        com.tencent.mm.kernel.g.Ei().DT().a(a.sYC, Boolean.valueOf(z));
        com.tencent.mm.kernel.g.Ei().DT().lm(true);
    }

    public static boolean bRt() {
        x.i("MicroMsg.WalletLockManager", "isUserSetFingerprintLock: %b", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.walletlock.fingerprint.a.a.bRt())});
        return com.tencent.mm.plugin.walletlock.fingerprint.a.a.bRt();
    }

    public static void bRZ() {
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.jG(true);
    }

    public static void jJ(boolean z) {
        x.i("MicroMsg.WalletLockManager", "alvinluo closeAllWalletLock");
        jK(z);
        jI(false);
    }

    public static void jK(boolean z) {
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.jG(false);
        if (z) {
            com.tencent.mm.plugin.walletlock.fingerprint.a.a.bRs();
        }
    }

    public final boolean bRq() {
        if (this.mType == 1) {
            return b.bRF();
        }
        if (this.mType != 2) {
            return false;
        }
        x.i("MicroMsg.WalletLockManager", "alvinluo isUserBlockedInFingerprint: %b", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.walletlock.fingerprint.a.a.bRu())});
        return com.tencent.mm.plugin.walletlock.fingerprint.a.a.bRu();
    }

    public static void bRv() {
        d.bRv();
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.bRv();
    }

    public static boolean bSa() {
        boolean z;
        if (((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getInt("TouchLockFunction", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        return h.bFl() && !z;
    }

    public static boolean bSb() {
        return ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getInt("TouchLockFunction", 0) != 1;
    }
}
