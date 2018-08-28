package com.tencent.mm.wallet_core;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;

public final class b {
    private static b uWS;

    public static b cCO() {
        if (uWS == null) {
            uWS = new b();
        }
        return uWS;
    }

    public static boolean cCP() {
        int i;
        c fJ = com.tencent.mm.model.c.c.Jx().fJ("100368");
        if (fJ.isValid() && "1".equals(fJ.ckq().get("open"))) {
            i = 1;
        } else {
            i = 0;
        }
        x.d("MicroMsg.TenPaySdkAbTest", "isPwdOpen2048 %s", new Object[]{Integer.valueOf(i)});
        if (i > 0) {
            return true;
        }
        return false;
    }

    public static boolean cCQ() {
        int i;
        c fJ = com.tencent.mm.model.c.c.Jx().fJ("100370");
        if (fJ.isValid() && "1".equals(fJ.ckq().get("open"))) {
            i = 1;
        } else {
            i = 0;
        }
        x.d("MicroMsg.TenPaySdkAbTest", "isOfflineOpen2048 %s", new Object[]{Integer.valueOf(i)});
        if (i > 0) {
            return true;
        }
        return false;
    }
}
