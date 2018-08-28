package com.tencent.mm.plugin.offline;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.al.a;

class g$2 implements a {
    final /* synthetic */ g lJa;

    g$2(g gVar) {
        this.lJa = gVar;
    }

    public final boolean vD() {
        if (g.a(this.lJa) != null) {
            if (!g.Eg().Dx()) {
                long asg = (long) g.asg();
                g.a(this.lJa).J(asg, asg);
            } else if (com.tencent.mm.plugin.offline.c.a.bma() && com.tencent.mm.plugin.offline.c.a.bly()) {
                g.bkL();
            }
        }
        return false;
    }
}
