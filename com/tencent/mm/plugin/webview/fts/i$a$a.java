package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.plugin.websearch.c.a.e;
import com.tencent.mm.plugin.webview.fts.i.a;
import com.tencent.mm.protocal.c.bxd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class i$a$a implements Runnable {
    j dFC;
    public volatile boolean gYf;
    final /* synthetic */ a pPC;

    private i$a$a(a aVar) {
        this.pPC = aVar;
    }

    public final void run() {
        if (!Thread.interrupted()) {
            if (bi.oW(this.dFC.bHt)) {
                x.i("MicroMsg.FTS.WebSearchLogic", "error query %d %d %d %d %s %d", Integer.valueOf(this.dFC.iPZ), Integer.valueOf(this.dFC.scene), Integer.valueOf(this.dFC.pKO), Integer.valueOf(this.dFC.pKQ), this.dFC.iow, Integer.valueOf(this.dFC.offset));
                return;
            }
            e eVar;
            switch (this.dFC.scene) {
                case 3:
                case 16:
                case 20:
                    ((n) g.n(n.class)).addSOSHistory(this.dFC.bHt);
                    break;
            }
            x.i("MicroMsg.FTS.WebSearchLogic", "start New NetScene %s ,  %d", this.dFC.bHt, Integer.valueOf(this.dFC.bWo));
            if (a.a(this.pPC) != null) {
                au.DF().c(a.a(this.pPC));
            }
            if (this.dFC.pKP == null || this.dFC.pKP.isEmpty()) {
                boolean z;
                String str = this.dFC.bHt;
                int i = this.dFC.scene;
                int i2 = this.dFC.iPZ;
                if (this.dFC.pKO == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (i.c(str, i, i2, z)) {
                    eVar = (e) i.a(this.pPC.pPx).Qb(this.dFC.bHt);
                    long currentTimeMillis = System.currentTimeMillis() - System.currentTimeMillis();
                    x.i("MicroMsg.FTS.WebSearchLogic", "match contact cost %d ms", Long.valueOf(currentTimeMillis));
                    h.mEJ.h(14717, this.dFC.bHt, Integer.valueOf(s.Hw()), Integer.valueOf(eVar.jte.size()), Long.valueOf(currentTimeMillis), Integer.valueOf(this.dFC.scene));
                    if (this.gYf) {
                        com.tencent.mm.plugin.webview.modeltools.e.bUU().pOB.h(this.dFC.scene, this.dFC.bHt, this.dFC.iPZ);
                        a.a(this.pPC, a.c(this.dFC));
                        if (eVar != null) {
                            LinkedList linkedList = new LinkedList();
                            for (e.a aVar : eVar.jte) {
                                bxd bxd = new bxd();
                                bxd.hbL = aVar.userName;
                                bxd.stJ = aVar.pNf;
                                bxd.hcS = aVar.bgn;
                                bxd.rul = aVar.fky;
                                bxd.eJM = aVar.cCR;
                                bxd.rej = aVar.desc;
                                linkedList.add(bxd);
                            }
                            a.a(this.pPC).ak(linkedList);
                        }
                        au.DF().a(a.a(this.pPC).getType(), this.pPC.pPx);
                        au.DF().a(a.a(this.pPC), 0);
                        x.i("MicroMsg.FTS.WebSearchLogic", "doScene(type : %s)", Integer.valueOf(a.a(this.pPC).getType()));
                        return;
                    }
                    x.i("MicroMsg.FTS.WebSearchLogic", "was cancelled");
                }
            }
            eVar = null;
            if (this.gYf) {
                com.tencent.mm.plugin.webview.modeltools.e.bUU().pOB.h(this.dFC.scene, this.dFC.bHt, this.dFC.iPZ);
                a.a(this.pPC, a.c(this.dFC));
                if (eVar != null) {
                    LinkedList linkedList2 = new LinkedList();
                    for (e.a aVar2 : eVar.jte) {
                        bxd bxd2 = new bxd();
                        bxd2.hbL = aVar2.userName;
                        bxd2.stJ = aVar2.pNf;
                        bxd2.hcS = aVar2.bgn;
                        bxd2.rul = aVar2.fky;
                        bxd2.eJM = aVar2.cCR;
                        bxd2.rej = aVar2.desc;
                        linkedList2.add(bxd2);
                    }
                    a.a(this.pPC).ak(linkedList2);
                }
                au.DF().a(a.a(this.pPC).getType(), this.pPC.pPx);
                au.DF().a(a.a(this.pPC), 0);
                x.i("MicroMsg.FTS.WebSearchLogic", "doScene(type : %s)", Integer.valueOf(a.a(this.pPC).getType()));
                return;
            }
            x.i("MicroMsg.FTS.WebSearchLogic", "was cancelled");
        }
    }
}
