package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.talkroom.b.c;
import com.tencent.mm.plugin.talkroom.component.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.as;

class g$6 extends a {
    final /* synthetic */ g oxj;

    g$6(g gVar) {
        this.oxj = gVar;
    }

    public final void k(int i, int i2, boolean z) {
        if (z) {
            g.b(this.oxj, 0);
            g.a(this.oxj).nr("");
            return;
        }
        g.c(this.oxj, i2);
        if (g.i(this.oxj) != i) {
            g.b(this.oxj, i);
            String bHc = this.oxj.bHc();
            if (!g.j(this.oxj) && bHc == null) {
                g.k(this.oxj);
                int e = g.e(this.oxj);
                long f = g.f(this.oxj);
                String g = g.g(this.oxj);
                g gVar = this.oxj;
                g.g(this.oxj);
                au.DF().a(new c(e, f, g, gVar.bHb()), 0);
                f bGW = b.bGW();
                bGW.oww++;
                bGW = b.bGW();
                bGW.owx++;
            }
            g.a(this.oxj).nr(bHc);
            as.I(ad.getContext(), R.l.talkroom_othersbegin);
        }
    }
}
