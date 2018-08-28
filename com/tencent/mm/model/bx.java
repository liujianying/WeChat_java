package com.tencent.mm.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

public final class bx {
    public static long IR() {
        if (!ad.cic()) {
            return 0;
        }
        g.Ek();
        if (!g.Eg().Dx()) {
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            g.Ek();
            Object obj = g.Ei().DT().get(a.sWU, null);
            if (obj != null) {
                return currentTimeMillis - bi.getLong(obj.toString(), 0);
            }
            return 0;
        } catch (Throwable th) {
            x.e("MicroMsg.TimeHelper", th.getMessage());
            return 0;
        }
    }
}
