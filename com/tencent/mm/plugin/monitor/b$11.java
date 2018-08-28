package com.tencent.mm.plugin.monitor;

import com.tencent.mm.g.a.lw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;

class b$11 extends c<lw> {
    final /* synthetic */ b lsb;

    b$11(b bVar) {
        this.lsb = bVar;
        this.sFo = lw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        g.Em();
        ah.M(b.i(this.lsb));
        g.Em().h(b.i(this.lsb), 3000);
        return false;
    }
}
