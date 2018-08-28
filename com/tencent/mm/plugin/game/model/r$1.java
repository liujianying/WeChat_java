package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.bjg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class r$1 implements Runnable {
    final /* synthetic */ l bFp;
    final /* synthetic */ r jMg;

    r$1(r rVar, l lVar) {
        this.jMg = rVar;
        this.bFp = lVar;
    }

    public final void run() {
        String str;
        r.a(this.jMg, r.a(this.jMg) + r.KD());
        bjg bjg = (bjg) ((bc) this.bFp).ivx.dIE.dIL;
        if (bjg == null) {
            x.e("MicroMsg.NetSceneSearchGameList", "resp == null");
            str = null;
        } else {
            str = bjg.rDK;
        }
        k kVar = new k(str);
        kVar.aTP();
        r.auZ().add(kVar);
        x.i("MicroMsg.GameListUpdater", "remainingCount: %d", new Object[]{Integer.valueOf(kVar.jLQ.optInt("remainingCount"))});
        if (kVar.jLQ.optInt("remainingCount") > 0) {
            g.DF().a(new bc(r.a(this.jMg), r.KD()), 0);
            return;
        }
        r.b(this.jMg);
        f.aTH();
        Object auZ = r.auZ();
        if (!bi.cX(auZ)) {
            g.Em().H(new k$1(auZ));
        }
    }
}
