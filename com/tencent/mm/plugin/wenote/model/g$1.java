package com.tencent.mm.plugin.wenote.model;

import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.protocal.c.wl;

class g$1 implements Runnable {
    final /* synthetic */ wl qof;
    final /* synthetic */ g qog;

    public g$1(g gVar, wl wlVar) {
        this.qog = gVar;
        this.qof = wlVar;
    }

    public final void run() {
        g gVar = new g();
        gVar.field_localId = g.a(this.qog);
        gVar.field_favProto = this.qof;
        this.qog.qnO = gVar.field_favProto;
        this.qog.qnF = gVar;
        g.a(this.qog, gVar);
        if (g.aTS().containsKey(g.b(this.qog))) {
            this.qog.qnE = (l) g.aTS().get(g.b(this.qog));
        } else {
            g.c(this.qog);
        }
        this.qog.cR(this.qog.qnE.msv);
        if (k.caj() != null) {
            k.can();
        }
    }

    public final String toString() {
        return super.toString() + "|dealWNoteInfo";
    }
}
