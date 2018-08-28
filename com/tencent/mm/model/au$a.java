package com.tencent.mm.model;

import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.api.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.j;
import com.tencent.mm.storage.l;
import com.tencent.mm.storage.n;
import java.util.HashMap;

class au$a implements b, a, c, e, com.tencent.mm.kernel.c.a {
    final /* synthetic */ au dBL;

    au$a(au auVar) {
        this.dBL = auVar;
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        if (cVar.dqH) {
            com.tencent.mm.s.c.Cp().u(262145, false);
        }
        h.mEJ.a(598, 13, 1, false);
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized start tid[%d]", new Object[]{Long.valueOf(Thread.currentThread().getId())});
        c a = au.a(this.dBL);
        com.tencent.mm.bt.h hVar = g.Ei().dqq;
        com.tencent.mm.bt.h hVar2 = g.Ei().dqr;
        f bcY = ((i) g.l(i.class)).bcY();
        bcY.a(new aq(bcY));
        com.tencent.mm.storage.h hVar3 = new com.tencent.mm.storage.h(bcY);
        a.dAd = hVar3;
        bcY.a(hVar3);
        a.dAb = new bn(hVar, ((i) g.l(i.class)).FW());
        a.dAc = new bm(hVar, ((i) g.l(i.class)).FR());
        a.dAe = new com.tencent.mm.model.b.c();
        a.dAf = new d();
        a.dAj = new com.tencent.mm.model.b.b();
        a.dAg = new j(hVar);
        a.dAh = new n(hVar);
        a.dAi = new l(hVar);
        h.mEJ.a(598, 14, 1, false);
        x.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done initDB take[%d]ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        c$a c_a = this.dBL.dBB;
        au.a(this.dBL);
        c_a.bu(cVar.dqH);
        h.mEJ.a(598, 15, 1, false);
        x.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done onAccountPostReset take[%d]ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        c_a = this.dBL.dBB;
        com.tencent.mm.compatible.util.f.zZ();
        h.mEJ.a(598, 16, 1, false);
        x.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done all take[%d]ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public void onAccountRelease() {
    }

    public void parallelsDependency() {
        com.tencent.mm.kernel.a.b.a.a(this, c.class).aN(g.n(o.class));
    }

    public void onDataBaseOpened(com.tencent.mm.bt.h hVar, com.tencent.mm.bt.h hVar2) {
        c$a c_a = this.dBL.dBB;
        au.a(this.dBL);
    }

    public void onDataBaseClosed(com.tencent.mm.bt.h hVar, com.tencent.mm.bt.h hVar2) {
    }

    public HashMap<Integer, com.tencent.mm.bt.h.d> collectDatabaseFactory() {
        x.i("MicroMsg.MMCore", "collectDatabaseFactory ");
        HashMap<Integer, com.tencent.mm.bt.h.d> hashMap = new HashMap();
        hashMap.putAll(c.cVM);
        return hashMap;
    }
}
