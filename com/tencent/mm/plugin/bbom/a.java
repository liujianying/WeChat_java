package com.tencent.mm.plugin.bbom;

import com.tencent.mm.g.a.gz;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.model.at;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.protocal.c.ar;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.u.b;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements com.tencent.mm.plugin.auth.a.a {
    public final void a(f fVar, g gVar, boolean z) {
        if ((gVar.qWn.srM & 2) != 0) {
            ar arVar = gVar.qWn.srO;
            if (!z) {
                au.HU();
                c.gi(arVar.raB);
            }
            String A = com.tencent.mm.aa.c.A(q.GF(), true);
            at.dBv.iy(A);
            com.tencent.mm.kernel.g.Ei().DT().a(com.tencent.mm.storage.aa.a.sZO, A);
            if (arVar.ray != 0) {
                au.HU();
                c.FZ().bJ(arVar.ray + "@qqim", 3);
            }
            com.tencent.mm.aa.c.d((long) arVar.ray, 3);
        } else {
            x.w("MicroMsg.BigBallAuthHandle", "summerauth updateProfile acctsect not set!");
        }
        o.iw(1);
        if (z) {
            gz gzVar = new gz();
            gzVar.bQj.bQk = false;
            com.tencent.mm.sdk.b.a.sFg.m(gzVar);
            ri riVar = new ri();
            riVar.ccb.ccc = true;
            com.tencent.mm.sdk.b.a.sFg.m(riVar);
            return;
        }
        au.Em().H(new 1(this));
    }

    public final void a(b bVar, String str, int i, String str2, String str3, int i2) {
        String A = com.tencent.mm.aa.c.A(q.GF(), true);
        at.dBv.iy(A);
        com.tencent.mm.kernel.g.Ei().DT().a(com.tencent.mm.storage.aa.a.sZO, A);
        com.tencent.mm.aa.c.d((long) i, 3);
        au.HU();
        c.FZ().bJ(bVar.qWZ.rZg, 2);
        if (i != 0) {
            au.HU();
            c.FZ().bJ(i + "@qqim", 3);
        }
    }
}
