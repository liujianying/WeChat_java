package com.tencent.mm.plugin.voip_cs.b;

import com.tencent.mm.g.a.bg;
import com.tencent.mm.g.a.bg.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class b$1 extends c<bg> {
    final /* synthetic */ b oWq;

    b$1(b bVar) {
        this.oWq = bVar;
        this.sFo = bg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = true;
        bg bgVar = (bg) bVar;
        if (bgVar instanceof bg) {
            a aVar = bgVar.bIM;
            if (!(b.bMw().oXs == 1 || b.bMw().oXs == 2)) {
                z = false;
            }
            aVar.bwu = z;
        }
        return false;
    }
}
