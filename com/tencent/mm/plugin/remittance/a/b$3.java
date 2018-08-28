package com.tencent.mm.plugin.remittance.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.c;
import com.tencent.mm.storage.x;

class b$3 implements a {
    final /* synthetic */ b mtR;

    b$3(b bVar) {
        this.mtR = bVar;
    }

    public final void a(String str, l lVar) {
        if (str != null && str.length() > 0 && "event_updated".equals(str)) {
            int i;
            c fJ = com.tencent.mm.model.c.c.Jx().fJ("100324");
            if (fJ.isValid() && "1".equals(fJ.ckq().get("open"))) {
                i = 1;
            } else {
                i = 0;
            }
            x DT = g.Ei().DT();
            DT.a(aa.a.sZl, Integer.valueOf(i));
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SubCoreRemittance", "receive abtest open bank remit: %s, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(((Integer) DT.get(aa.a.sZm, Integer.valueOf(0))).intValue())});
            if (((Integer) DT.get(aa.a.sZm, Integer.valueOf(0))).intValue() == 0) {
                com.tencent.mm.s.c.Cp().b(aa.a.sZg, true);
                DT.a(aa.a.sZm, Integer.valueOf(1));
                g.Ei().DT().a(aa.a.sZh, Boolean.valueOf(false));
            }
        }
    }
}
