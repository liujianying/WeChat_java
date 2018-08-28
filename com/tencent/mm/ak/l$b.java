package com.tencent.mm.ak;

import com.tencent.mm.ak.l.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class l$b {
    final /* synthetic */ l dVN;
    public a dVQ;

    final void OS() {
        e d;
        if (l.b(this.dVN) == l.c(this.dVN)) {
            d = l.d(this.dVN);
        } else {
            d = l.e(this.dVN);
        }
        if (d.dTW == 1) {
            g.vv(23);
            g.vv(21);
        }
        if (o.Pf().a(Long.valueOf(l.c(this.dVN)), l.d(this.dVN)) < 0) {
            x.e(l.f(this.dVN), "update db failed local id:" + l.c(this.dVN) + " server id:" + l.d(this.dVN).bYu);
            i.hU((int) l.b(this.dVN));
            i.hT((int) l.b(this.dVN));
            l.g(this.dVN).a(3, -1, "", this.dVN);
        }
        if (l.c(this.dVN) != l.b(this.dVN)) {
            o.Pf().a(Long.valueOf(l.b(this.dVN)), l.e(this.dVN));
        }
        l.a(this.dVN, l.c(this.dVN));
        if (l.b(this.dVN) != l.c(this.dVN)) {
            l.a(this.dVN, l.b(this.dVN));
        }
        if (this.dVQ != null) {
            this.dVQ.OS();
        }
        this.dVN.hV(l.h(this.dVN));
        l.i(this.dVN);
    }

    public l$b(l lVar, a aVar) {
        this.dVN = lVar;
        this.dVQ = aVar;
    }
}
