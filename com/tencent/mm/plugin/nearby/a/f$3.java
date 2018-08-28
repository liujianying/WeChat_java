package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.jz;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.sdk.b.b;

class f$3 extends c<jz> {
    final /* synthetic */ f lBu;

    f$3(f fVar) {
        this.lBu = fVar;
    }

    public final /* synthetic */ b a(int i, l lVar, b bVar) {
        jz jzVar = (jz) bVar;
        c cVar = (c) lVar;
        jzVar.bUf.bUl = cVar.biQ();
        jzVar.bUf.bUn = cVar.biR();
        jzVar.bUf.bUm = cVar.biS();
        jzVar.bUf.bNI = jzVar.bUe.bNI;
        return jzVar;
    }

    public final /* synthetic */ boolean a(b bVar) {
        jz jzVar = (jz) bVar;
        if (jzVar.bUe.bTN) {
            c.k(jzVar);
        } else {
            l(jzVar);
        }
        return false;
    }

    public final /* synthetic */ l b(b bVar) {
        jz jzVar = (jz) bVar;
        return new c(jzVar.bUe.bNI, jzVar.bUe.bUg, jzVar.bUe.bSx, jzVar.bUe.bUh, jzVar.bUe.bUi, jzVar.bUe.bUj, jzVar.bUe.bUk);
    }

    public final int aAu() {
        return 148;
    }
}
