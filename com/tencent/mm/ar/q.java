package com.tencent.mm.ar;

import com.tencent.mm.g.a.lw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class q extends c<lw> {
    private static long cXx = 86400000;

    public q() {
        this.sFo = lw.class.getName().hashCode();
    }

    private static boolean Qn() {
        x.d("MicroMsg.PostTaskUpdateConfigListListener", "callback expired : " + xG());
        if (xG()) {
            c.Qj().update();
        }
        return false;
    }

    private static boolean xG() {
        if (bi.bG(Long.valueOf(bi.c((Long) g.Ei().DT().get(81938, null))).longValue()) * 1000 > cXx) {
            return true;
        }
        return false;
    }
}
