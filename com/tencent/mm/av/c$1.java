package com.tencent.mm.av;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    final /* synthetic */ c eeq;

    c$1(c cVar) {
        this.eeq = cVar;
    }

    public final boolean vD() {
        x.w("MicroMsg.SenseWhereHttpUtil", "it is time up, has no sense where response.");
        if (c.a(this.eeq) != null) {
            g.Eh().dpP.c(c.a(this.eeq));
        }
        c.b(this.eeq);
        c.c(this.eeq);
        synchronized (c.d(this.eeq)) {
            c.d(this.eeq).notifyAll();
        }
        return false;
    }
}
