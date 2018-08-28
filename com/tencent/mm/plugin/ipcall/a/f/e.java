package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.h;
import com.tencent.mm.protocal.c.bcd;

public final class e extends a implements h.a {
    private h ksq = null;

    public final int[] aXB() {
        return new int[0];
    }

    public final int Mw() {
        return 8;
    }

    public final void aXC() {
        this.ksq = new h();
        this.ksq.koL = this;
        com.tencent.mm.sdk.b.a.sFg.b(this.ksq);
    }

    public final void onDestroy() {
        com.tencent.mm.sdk.b.a.sFg.c(this.ksq);
    }

    public final void b(c cVar) {
    }

    public final void a(int i, int i2, String str, l lVar) {
    }

    public final void a(bcd bcd) {
        this.kpk.a(8, bcd, 0, 0);
    }
}
