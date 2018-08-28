package com.tencent.mm.modelvideo;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.al.a;

class g$2 implements a {
    final /* synthetic */ g emA;

    g$2(g gVar) {
        this.emA = gVar;
    }

    public final boolean vD() {
        if (this.emA.a(g.o(this.emA), g.f(this.emA)) == -1) {
            g.a(this.emA, 0 - (g.getLine() + 10000));
            g.f(this.emA).a(3, -1, "doScene failed", this.emA);
        }
        return false;
    }
}
