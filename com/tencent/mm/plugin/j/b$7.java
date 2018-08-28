package com.tencent.mm.plugin.j;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.j.c.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.aa.a;

class b$7 implements Runnable {
    final /* synthetic */ b hsX;

    b$7(b bVar) {
        this.hsX = bVar;
    }

    public final void run() {
        if (b.e(this.hsX)) {
            if (this.hsX.avu()) {
                h.mEJ.a(664, 3, 1, false);
            } else if (b.f(this.hsX) == null) {
                b.b(this.hsX, new c("message", b.avw(), b.avx(), b.g(this.hsX)));
                b.d(this.hsX).h(b.f(this.hsX), 2000);
                if (((Long) g.Ei().DT().get(a.sYl, Long.valueOf(0))).longValue() <= 0) {
                    g.Ei().DT().a(a.sYl, Long.valueOf(bi.VE()));
                }
            }
        } else if (b.f(this.hsX) != null) {
            b.f(this.hsX).isStop = true;
            b.b(this.hsX, null);
        }
    }
}
