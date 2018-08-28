package com.tencent.mm.plugin.sns;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.hr;
import com.tencent.mm.g.a.ob;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.boz;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends c<hr> implements e {
    private int nha;
    private boy nhb;
    private n nhc;
    private al nhd;

    public d() {
        this.sFo = hr.class.getName().hashCode();
    }

    private boolean a(hr hrVar) {
        if (hrVar instanceof hr) {
            this.nha = hrVar.bRa.bMQ;
            this.nhc = af.byo().xd(this.nha);
            this.nhb = aj.m(this.nhc);
            if (this.nhb == null || ((this.nhb.rXx != 3 || this.nhb.smW == null || this.nhb.smW.size() <= 0) && (this.nhb.rXx != 5 || this.nhb.rWm == null || this.nhb.rWm.size() <= 0))) {
                q qVar = new q(this.nhc.field_snsId);
                ((boz) qVar.diG.dID.dIL).snc = 1;
                g.Ek();
                g.Eh().dpP.a(210, this);
                g.Ek();
                g.Eh().dpP.a(qVar, 0);
                this.nhd = new al(new 1(this), false);
                this.nhd.J(10000, 10000);
                return true;
            }
            hrVar.bRb.bRc = this.nhb;
            return true;
        }
        x.f("MicroMsg.GetSnsObjectDetailListener", "mismatched event");
        return false;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.GetSnsObjectDetailListener", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.nhd.SO();
        if (i == 0 && i2 == 0) {
            n fi = af.byo().fi(this.nhc.field_snsId);
            ob obVar = new ob();
            obVar.bYX.bRc = aj.m(fi);
            a.sFg.m(obVar);
            return;
        }
        ob obVar2 = new ob();
        obVar2.bYX.bRc = null;
        a.sFg.m(obVar2);
    }
}
