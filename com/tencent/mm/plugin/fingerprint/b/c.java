package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements j {
    public static boolean aNd() {
        boolean aNh = ((k) g.l(k.class)).aNh();
        x.i("MicroMsg.FingerPrintAuthMgr", "isSupportFP is " + aNh);
        return aNh;
    }

    public static int a(com.tencent.mm.pluginsdk.wallet.c cVar, boolean z) {
        return ((k) g.l(k.class)).a(cVar, z);
    }

    public static void release() {
        ((k) g.l(k.class)).aNn();
    }

    public static void abort() {
        ((k) g.l(k.class)).aNo();
    }

    public static void aNe() {
        ((k) g.l(k.class)).aNe();
    }

    public static boolean aNf() {
        return ((k) g.l(k.class)).aNi();
    }

    public static com.tencent.mm.pluginsdk.wallet.j aNg() {
        return ((k) g.l(k.class)).aNg();
    }
}
