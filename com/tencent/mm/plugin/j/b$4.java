package com.tencent.mm.plugin.j;

import com.tencent.mm.g.a.jj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.j.c.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.aa;

class b$4 implements Runnable {
    final /* synthetic */ b hsX;
    final /* synthetic */ boolean hta;

    b$4(b bVar, boolean z) {
        this.hsX = bVar;
        this.hta = z;
    }

    public final void run() {
        if (this.hta) {
            b.a(this.hsX, true);
        }
        if (b.a(this.hsX) && b.b(this.hsX) == null) {
            jj jjVar = new jj();
            if (this.hsX.avu()) {
                b.a(this.hsX, false);
                jjVar.bSO.bwt = true;
                a.sFg.m(jjVar);
                h.mEJ.a(664, 9, 1, false);
                return;
            }
            if (this.hta) {
                h.mEJ.a(664, 7, 1, false);
            }
            jjVar.bSO.bSP = b.avw();
            jjVar.bSO.bSQ = b.avt();
            jjVar.bSO.bwt = false;
            a.sFg.m(jjVar);
            b.a(this.hsX, new c("message", b.avw(), b.avx(), b.c(this.hsX)));
            b.d(this.hsX).H(b.b(this.hsX));
            if (((Long) g.Ei().DT().get(aa.a.sYl, Long.valueOf(0))).longValue() <= 0) {
                g.Ei().DT().a(aa.a.sYl, Long.valueOf(bi.VE()));
            }
        }
    }
}
