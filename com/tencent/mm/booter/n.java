package com.tencent.mm.booter;

import com.tencent.mm.ar.k;
import com.tencent.mm.aw.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ai;

public final class n {
    private static long cXx = 86400000;

    public static void run() {
        boolean z;
        au.HU();
        if (ai.bG(Long.valueOf(ai.c((Long) c.DT().get(81944, null))).longValue()) * 1000 > cXx) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            d RI = d.RI();
            d.RJ();
            if (!RI.dFt) {
                g.Ek();
                if (g.Ei().isSDCardAvailable()) {
                    RI.release();
                    RI.dFt = true;
                    g.DF().a(159, RI);
                    g.DF().a(new k(9), 0);
                }
            }
        }
    }
}
