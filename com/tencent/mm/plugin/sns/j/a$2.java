package com.tencent.mm.plugin.sns.j;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ay;
import com.tencent.mm.vending.app.a.a;

class a$2 extends a<c.a> {
    final /* synthetic */ a onj;

    a$2(a aVar) {
        this.onj = aVar;
        super(aVar);
    }

    protected final /* synthetic */ Object Wd() {
        x.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor index %s", new Object[]{c.a.class});
        a aVar = this.onj;
        c.a aVar2 = new c.a();
        aVar.ocK = aVar.uPN.getIntExtra("sns_source", 0);
        aVar.gtX = aVar.uPN.getStringExtra("sns_userName");
        if (aVar.gtX == null) {
            aVar.gtX = "";
        }
        g.Ek();
        aVar.ocJ = ((i) g.l(i.class)).FR().Yc(aVar.gtX);
        aVar.ocI = q.GF();
        aVar.nNG = aVar.ocI.equals(aVar.gtX);
        ay byc = af.byc();
        String aG = bi.aG(aVar.uPN.getStringExtra("sns_signature"), "");
        String aG2 = bi.aG(aVar.uPN.getStringExtra("sns_nickName"), "");
        com.tencent.mm.l.a Yg = (aVar.gtX == null || aVar.gtX.equals("")) ? byc.Yg(aVar.ocI) : byc.Yg(aVar.gtX);
        if (Yg != null && ((int) Yg.dhP) > 0) {
            aG = Yg.signature;
            aG2 = Yg.BK();
            x.i("MicroMsg.SnsTimelineInteractor", "contact:user[%s] id[%d] nickname[%s]", new Object[]{Yg.field_username, Integer.valueOf((int) Yg.dhP), aG2});
        }
        aVar2.gtX = aVar.gtX;
        aVar2.ocI = aVar.ocI;
        aVar2.ocJ = aVar.ocJ;
        aVar2.nNG = aVar.nNG;
        aVar2.ocK = aVar.ocK;
        aVar2.eWQ = aG2;
        aVar2.ogj = aG;
        return aVar2;
    }
}
