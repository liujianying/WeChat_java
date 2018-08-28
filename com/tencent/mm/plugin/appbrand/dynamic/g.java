package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class g {
    private static a fuN = new 1();

    public static void initialize() {
        if (ad.cic()) {
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().a(fuN);
        }
    }

    public static void release() {
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().b(fuN);
    }
}
