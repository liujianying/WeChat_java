package com.tencent.mm.plugin.walletlock.b;

import com.tencent.mm.sdk.platformtools.x;

public final class h {
    private static long iNJ = -1;

    public static void ed(int i, int i2) {
        int i3;
        switch (i2) {
            case 5:
                i3 = 5;
                break;
            case 10:
                i3 = 6;
                break;
            case 26:
                if (i != 3) {
                    i3 = -1;
                    break;
                } else {
                    i3 = 4;
                    break;
                }
            default:
                i3 = -1;
                break;
        }
        if (i3 != -1) {
            x.i("MicroMsg.WalletLockReportManager", "alvinluo wallet lock idkey report id: %d, key: %d, value: %d", new Object[]{Integer.valueOf(713), Integer.valueOf(i3), Long.valueOf(1)});
            com.tencent.mm.plugin.report.service.h.mEJ.a(713, (long) i3, 1, false);
        }
    }

    public static void jL(boolean z) {
        long j;
        x.i("MicroMsg.WalletLockReportManager", "alvinluo idkey fingerprint open result: %b", new Object[]{Boolean.valueOf(z)});
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.mEJ;
        if (z) {
            j = 0;
        } else {
            j = 1;
        }
        hVar.a(713, j, 1, false);
    }

    public static void bSc() {
        x.i("MicroMsg.WalletLockReportManager", "alvinluo idkey report fingerprintlock verify by passwd success");
        com.tencent.mm.plugin.report.service.h.mEJ.a(713, 2, 1, false);
    }

    public static void bSd() {
        x.i("MicroMsg.WalletLockReportManager", "alvinluo idkey report close wallet lock success");
        com.tencent.mm.plugin.report.service.h.mEJ.a(713, 3, 1, false);
    }

    public static void bSe() {
        iNJ = System.currentTimeMillis();
        x.i("MicroMsg.WalletLockReportManager", "alvinluo wallet lock report create session: %d", new Object[]{Long.valueOf(iNJ)});
    }

    public static void Z(int i, int i2, int i3) {
        if (iNJ == -1) {
            x.e("MicroMsg.WalletLockReportManager", "alvinluo wallet lock report sessionId is -1, not create session, ignore");
        } else if (i != -1) {
            x.i("MicroMsg.WalletLockReportManager", "alvinluo reportVerifyWalletLock session: %d, protectScene: %d, walletLockType: %d, result: %d", new Object[]{Long.valueOf(iNJ), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            com.tencent.mm.plugin.report.service.h.mEJ.h(14839, new Object[]{Long.valueOf(iNJ), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        }
    }
}
