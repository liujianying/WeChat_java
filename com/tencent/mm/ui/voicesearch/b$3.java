package com.tencent.mm.ui.voicesearch;

import com.tencent.mm.aa.q;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.protocal.c.biy;
import com.tencent.mm.protocal.c.bja;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class b$3 implements Runnable {
    final /* synthetic */ l bFp;
    final /* synthetic */ b uFM;

    b$3(b bVar, l lVar) {
        this.uFM = bVar;
        this.bFp = lVar;
    }

    public final void run() {
        bja bcS = ((f) this.bFp).bcS();
        x.d("MicroMsg.SearchResultAdapter", "count " + bcS.rHb);
        if (bcS.rHb > 0) {
            for (biy biy : bcS.rHc) {
                if (s.gU(biy.rTe)) {
                    if (b.f(this.uFM) == null) {
                        b.a(this.uFM, new LinkedList());
                    }
                    b.f(this.uFM).add(biy);
                }
            }
        } else {
            String a = ab.a(bcS.rvi);
            x.d("MicroMsg.SearchResultAdapter", "user " + a);
            if (bi.oV(a).length() > 0) {
                biy biy2 = new biy();
                biy2.rvi = bcS.rvi;
                biy2.rTe = bcS.rTe;
                biy2.eJK = bcS.eJK;
                biy2.rQz = bcS.rQz;
                biy2.eJM = bcS.eJM;
                biy2.eJQ = bcS.eJQ;
                biy2.eJJ = bcS.eJJ;
                biy2.eJI = bcS.eJI;
                biy2.eJH = bcS.eJH;
                biy2.rTf = bcS.rTf;
                biy2.rTi = bcS.rTi;
                biy2.rTg = bcS.rTg;
                biy2.rTh = bcS.rTh;
                biy2.rTk = bcS.rTk;
                q.Kp().g(a, ab.a(bcS.rcn));
                if (b.f(this.uFM) == null) {
                    b.a(this.uFM, new LinkedList());
                }
                b.f(this.uFM).clear();
                if (s.gU(biy2.rTe)) {
                    b.f(this.uFM).add(biy2);
                }
                x.d("MicroMsg.SearchResultAdapter", "count " + b.f(this.uFM).size());
            }
        }
        b.b(this.uFM, false);
    }
}
