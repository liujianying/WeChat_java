package com.tencent.mm.plugin.walletlock.gesture.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

public final class b {
    public static boolean bRE() {
        return ((Boolean) g.Ei().DT().get(a.sYC, Boolean.valueOf(false))).booleanValue();
    }

    public static boolean bRF() {
        g bRG = d.bRG();
        x.v("MicroMsg.GestureUtil", "alvinluo timeInfo: %d, %d", new Object[]{Long.valueOf(bRG.pGZ), Long.valueOf(bRG.pHa)});
        if (bRG.pGZ != -1) {
            e.a(bRG);
            if (bRG.pHa / 1000 < 600) {
                d.H(bRG.pGZ, bRG.pHa);
                return true;
            }
            d.bRH();
        }
        return false;
    }
}
