package com.tencent.mm.model.a;

import com.tencent.mm.ab.d.a;
import com.tencent.mm.ab.d.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

public final class d implements com.tencent.mm.ab.d {
    public final b b(a aVar) {
        by byVar = aVar.dIN;
        if (byVar == null || byVar.rcl == null) {
            x.f("MicroMsg.abtest.AbTestMsgExtension", "[Abtest] AbTestMsgExtension failed, invalid cmdAM");
        } else {
            String a = ab.a(byVar.rcl);
            g.Ei().DT().set(328193, a);
            c IW = g.IW();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                IW.iQ(a);
                a = (String) g.Ei().DT().get(328197, null);
                if (bi.oW(a) || !(IW.dDN == null || a.equals(IW.dDN.dDJ))) {
                    g.Ei().DT().set(328197, IW.dDN.dDJ);
                    g.Ei().DT().set(328195, Boolean.valueOf(false));
                    g.Ei().DT().set(328194, Boolean.valueOf(false));
                    g.Ei().DT().set(328196, Boolean.valueOf(false));
                    x.i("MicroMsg.abtest.AbTestManager", "[cpan] new case id or new case id , reset click value.");
                }
            } catch (Exception e) {
                x.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", new Object[]{e.toString()});
            }
            x.i("MicroMsg.abtest.AbTestManager", "[Abtest] update use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            if (g.IW().IU()) {
                f.iS(g.IW().dDN.dDJ);
            }
        }
        return null;
    }

    public final void h(bd bdVar) {
    }
}
