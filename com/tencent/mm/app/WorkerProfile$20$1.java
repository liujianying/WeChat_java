package com.tencent.mm.app;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.app.WorkerProfile.20;
import com.tencent.mm.g.a.na;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelappbrand.n;
import com.tencent.mm.protocal.c.aho;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

class WorkerProfile$20$1 implements e {
    final /* synthetic */ 20 bzS;

    WorkerProfile$20$1(20 20) {
        this.bzS = 20;
    }

    public final void a(int i, int i2, String str, l lVar) {
        au.DF().b(1145, this);
        x.i("MicroMsg.WorkerProfile", "onSceneEnd(GetServiceNotifyOptions), errType : %d, errCode : %d, errMsg : %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0 && lVar.getType() == 1145) {
            n nVar = (n) lVar;
            if ((((aho) nVar.dFA.dID.dIL).rKO & 1) != 0) {
                boolean z = nVar.JR().rgU;
                au.HU();
                if (z != c.DT().getBoolean(a.sUk, true)) {
                    x.i("MicroMsg.WorkerProfile", "service notify message notice switch changed(to : %b)", new Object[]{Boolean.valueOf(z)});
                    au.HU();
                    c.DT().a(a.sUk, Boolean.valueOf(z));
                    com.tencent.mm.sdk.b.a.sFg.m(new na());
                }
                z = nVar.JR().rKP;
                au.HU();
                if (z != c.DT().getBoolean(a.sUl, true)) {
                    x.i("MicroMsg.WorkerProfile", "wxa custom session notify message notice switch changed(to : %b)", new Object[]{Boolean.valueOf(z)});
                    au.HU();
                    c.DT().a(a.sUl, Boolean.valueOf(z));
                    com.tencent.mm.sdk.b.a.sFg.m(new na());
                }
            }
        }
    }
}
