package com.tencent.mm.plugin.j;

import com.tencent.mm.g.a.bm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class b$3 extends c<bm> {
    final /* synthetic */ b hsX;

    b$3(b bVar) {
        this.hsX = bVar;
        this.sFo = bm.class.getName().hashCode();
    }

    private boolean avz() {
        x.i("MicroMsg.CalcWxService", "%s clean wx file index event ", new Object[]{this.hsX.avy()});
        b.d(this.hsX, true);
        try {
            g.Em().H(new 1(this));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CalcWxService", e, "%s clean wx file error", new Object[]{this.hsX.avy()});
        }
        return false;
    }
}
