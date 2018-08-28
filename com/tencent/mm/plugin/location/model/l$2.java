package com.tencent.mm.plugin.location.model;

import com.tencent.mm.ax.g;
import com.tencent.mm.ay.d;
import com.tencent.mm.g.a.er;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class l$2 extends c<er> {
    final /* synthetic */ l kDB;

    l$2(l lVar) {
        this.kDB = lVar;
        this.sFo = er.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        er erVar = (er) bVar;
        x.i("MicroMsg.SubCoreLocation", "exit track trackMgr:%s event:%s", new Object[]{d.eli.SD(), erVar.bMv.username});
        l.aZi().stop();
        if (!bi.oW(d.elh.SC())) {
            l.aZi().rP(1);
            rn rnVar = new rn();
            rnVar.ccn.ccq = true;
            a.sFg.m(rnVar);
        }
        if (!bi.oW(erVar.bMv.username)) {
            com.tencent.mm.plugin.location.a.a FM = l.aZj().FM(erVar.bMv.username);
            if (FM != null) {
                FM.bUb.remove(q.GF());
                l.aZj().a(erVar.bMv.username, FM.bUb, FM.latitude, FM.longitude, FM.kCs, null, null);
                if (g.elf != null) {
                    g.elf.a(erVar.bMv.username, null, null, null, 1);
                }
            }
        }
        return false;
    }
}
