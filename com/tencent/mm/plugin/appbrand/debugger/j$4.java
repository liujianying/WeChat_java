package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.g.a.m;
import com.tencent.mm.protocal.c.cbm;
import com.tencent.mm.sdk.b.c;

class j$4 extends c<m> {
    final /* synthetic */ j fti;

    j$4(j jVar) {
        this.fti = jVar;
        this.sFo = m.class.getName().hashCode();
    }

    private boolean a(m mVar) {
        if (!(mVar == null || mVar.bGA == null || mVar.bGA.bGD == null)) {
            cbm cbm = new cbm();
            cbm.bGB = mVar.bGA.bGB;
            cbm.bGC = mVar.bGA.bGC;
            cbm.sxC = mVar.bGA.bGD.toString();
            cbm.timestamp = System.currentTimeMillis();
            this.fti.a(p.a(cbm, this.fti.ftb, "networkDebugAPI"));
        }
        return true;
    }
}
