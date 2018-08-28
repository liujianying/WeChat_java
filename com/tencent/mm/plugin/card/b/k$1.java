package com.tencent.mm.plugin.card.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.s.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

class k$1 implements Runnable {
    k$1() {
    }

    public final void run() {
        x.i("MicroMsg.CardMsgManager", "begin to clearRedDotAndWording()");
        g.Ei().DT().a(a.sPS, "");
        g.Ei().DT().a(a.sPY, Integer.valueOf(0));
        g.Ei().DT().a(a.sPV, "");
        g.Ei().DT().a(a.sPW, "");
        g.Ei().DT().a(a.sPX, "");
        g.Ei().DT().a(a.sQj, "");
        g.Ei().DT().a(a.sQk, Boolean.valueOf(false));
        if (c.Cp().aU(262152, 266256)) {
            c.Cp().v(262152, false);
        }
        if (c.Cp().aT(262152, 266256)) {
            c.Cp().u(262152, false);
        }
        if (c.Cp().a(a.sPM, a.sPO)) {
            c.Cp().a(a.sPM, false);
        }
        if (c.Cp().a(a.sPN, a.sPP)) {
            c.Cp().a(a.sPN, false);
        }
        x.i("MicroMsg.CardMsgManager", "end to clearRedDotAndWording()");
    }
}
