package com.tencent.mm.plugin.appbrand.appcache.a.a;

import com.tencent.mm.protocal.c.akl;
import com.tencent.mm.protocal.c.akm;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.j.c;

class a$2 implements a<c<akl, akm>, com.tencent.mm.ab.a.a<akm>> {
    final /* synthetic */ boolean fiE;
    final /* synthetic */ int fiF;
    final /* synthetic */ b fiG;
    final /* synthetic */ a fiH;

    a$2(a aVar, b bVar, boolean z, int i) {
        this.fiH = aVar;
        this.fiG = bVar;
        this.fiE = z;
        this.fiF = i;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.ab.a.a aVar = (com.tencent.mm.ab.a.a) obj;
        if (com.tencent.mm.plugin.appbrand.j.a.b(aVar)) {
            com.tencent.mm.ab.b bVar = (com.tencent.mm.ab.b) aVar.bKq.dJd;
            return com.tencent.mm.vending.j.a.x((akl) bVar.dID.dIL, (akm) bVar.dIE.dIL);
        }
        this.fiG.v(new Object[]{Boolean.valueOf(false)});
        g.cBF().ct(Boolean.valueOf(false));
        int i = this.fiE ? 50 : 49;
        int i2 = com.tencent.mm.plugin.appbrand.appcache.a.c.a.fiY;
        com.tencent.mm.plugin.appbrand.appcache.a.c.a.n((long) this.fiF, (long) i);
        return null;
    }
}
