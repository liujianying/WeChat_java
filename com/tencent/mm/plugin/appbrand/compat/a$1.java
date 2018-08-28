package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.protocal.c.akg;

class a$1 implements a {
    final /* synthetic */ com.tencent.mm.plugin.appbrand.compat.a.a.a fop;
    final /* synthetic */ a foq;

    a$1(a aVar, com.tencent.mm.plugin.appbrand.compat.a.a.a aVar2) {
        this.foq = aVar;
        this.fop = aVar2;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        boolean z = true;
        if (lVar.getType() == 1926) {
            boolean z2;
            if (i == 0 && i2 == 0) {
                akg akg = (akg) bVar.dIE.dIL;
                z2 = akg != null && akg.rMV;
            } else {
                z2 = false;
                z = false;
            }
            if (this.fop != null) {
                this.fop.q(z, z2);
            }
        }
        return 0;
    }
}
