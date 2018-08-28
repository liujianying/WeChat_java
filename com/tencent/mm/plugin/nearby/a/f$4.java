package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.ka;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.protocal.c.aqv;
import com.tencent.mm.protocal.c.aqx;
import com.tencent.mm.sdk.b.b;
import java.util.Iterator;
import java.util.LinkedList;

class f$4 extends c<ka> {
    final /* synthetic */ f lBu;

    f$4(f fVar) {
        this.lBu = fVar;
    }

    public final /* synthetic */ b a(int i, l lVar, b bVar) {
        ka kaVar = (ka) bVar;
        e eVar = (e) lVar;
        kaVar.bUp.bSU = ((aqx) eVar.diG.dIE.dIL).hLg;
        ka.b bVar2 = kaVar.bUp;
        LinkedList linkedList = ((aqx) eVar.diG.dIE.dIL).rbQ;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                aqv aqv = (aqv) it.next();
                au.HU();
                com.tencent.mm.model.c.Gw().fX(aqv.hbL, aqv.rEJ);
            }
        }
        bVar2.bUb = linkedList;
        return kaVar;
    }

    public final /* synthetic */ boolean a(b bVar) {
        ka kaVar = (ka) bVar;
        if (kaVar.bUo.bTN) {
            c.k(kaVar);
        } else {
            l(kaVar);
        }
        return false;
    }

    public final /* synthetic */ l b(b bVar) {
        return new e(((ka) bVar).bUo.bSr);
    }

    public final int aAu() {
        return 377;
    }
}
