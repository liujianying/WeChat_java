package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.ng;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class af$21 extends c<ng> {
    final /* synthetic */ af nqT;

    af$21(af afVar) {
        this.nqT = afVar;
        this.sFo = ng.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        SnsAdClick snsAdClick = ((ng) bVar).bYk.bYl;
        com.tencent.mm.plugin.sns.a.b.c cVar = new com.tencent.mm.plugin.sns.a.b.c(snsAdClick.egF, snsAdClick.egJ, snsAdClick.scene, "", snsAdClick.egL, snsAdClick.egG);
        g.Ek();
        g.Eh().dpP.a(cVar, 0);
        return false;
    }
}
