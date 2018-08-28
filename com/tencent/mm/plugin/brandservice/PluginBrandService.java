package com.tencent.mm.plugin.brandservice;

import android.os.Looper;
import com.tencent.mm.ac.z;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.s;

public class PluginBrandService extends f implements c, b {
    private a dYI = new 3(this);
    private r.c hnE = new 4(this);

    public void installed() {
        alias(b.class);
    }

    public void configure(g gVar) {
        addBrandServiceEvent();
        if (gVar.ES()) {
            pin(new p(c.class));
            ((o) com.tencent.mm.kernel.g.n(o.class)).setBizTimeLineCallback(new 1(this));
        }
    }

    public void execute(g gVar) {
        com.tencent.mm.bg.c.Um("brandservice");
    }

    public void onAccountInitialized(e.c cVar) {
        ((i) com.tencent.mm.kernel.g.l(i.class)).bcY().a(this.dYI, Looper.getMainLooper());
        z.Ne().a(this.hnE, Looper.getMainLooper());
        z.Nf().a(this.hnE, Looper.getMainLooper());
        d dVar = new d();
        if (s.auK()) {
            x.i("MicroMsg.BizTimeLineMigrateImp", "migrateMainCell");
            int intValue = ((Integer) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sZY, Integer.valueOf(0))).intValue();
            if ((intValue & 1) == 0) {
                ((i) com.tencent.mm.kernel.g.l(i.class)).FW().Ys("officialaccounts");
                com.tencent.mm.kernel.g.Ei().DT().a(aa.a.sZY, Integer.valueOf(intValue | 1));
            }
        }
    }

    public void onAccountRelease() {
        ((i) com.tencent.mm.kernel.g.l(i.class)).bcY().a(this.dYI);
        z.Ne().a(this.hnE);
        z.Nf().a(this.hnE);
    }

    private void addBrandServiceEvent() {
        com.tencent.mm.sdk.b.a.sFg.b(new 2(this));
    }
}
