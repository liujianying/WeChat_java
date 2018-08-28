package com.tencent.mm.plugin.wallet.pay.a.b;

import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    private static long pfm = 0;

    public static void ae(String str, int i, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - pfm > 1000) {
            l cVar;
            pfm = currentTimeMillis;
            if (!bi.oW(str)) {
                if (str.startsWith("sns_aa_")) {
                    cVar = new c(str, i, i2);
                } else if (str.startsWith("sns_tf_")) {
                    cVar = new f(str, i, i2);
                } else if (str.startsWith("sns_ff_")) {
                    cVar = new e(str, i, i2);
                } else if (str.startsWith("sns_")) {
                    cVar = new d(str, i, i2);
                } else if (str.startsWith("ts_")) {
                    cVar = new g(str, i, i2);
                }
                if (cVar != null) {
                    x.v("NetSceneCancelPayHelper", "start cancelPay request");
                    g.Ek();
                    g.Eh().dpP.a(cVar, 0);
                }
            }
            cVar = null;
            if (cVar != null) {
                x.v("NetSceneCancelPayHelper", "start cancelPay request");
                g.Ek();
                g.Eh().dpP.a(cVar, 0);
            }
        }
    }
}
