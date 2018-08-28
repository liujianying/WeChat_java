package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.g.a.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;

class f$1 extends c<d> {
    final /* synthetic */ f juX;

    f$1(f fVar) {
        this.juX = fVar;
        this.sFo = d.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (!((d) bVar).bGd.bGe) {
            ah.i(new 1(this), 10000);
            this.juX.juU.dead();
        }
        return false;
    }
}
