package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.pz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsTimeLineUI$9 extends c<pz> {
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$9(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
        this.sFo = pz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        pz pzVar = (pz) bVar;
        if (!(SnsTimeLineUI.g(this.odw) == null || SnsTimeLineUI.g(this.odw).nLK == null)) {
            com.tencent.mm.plugin.sns.h.b bVar2 = SnsTimeLineUI.g(this.odw).nLK.nrb;
            bVar2.nxa.add(pzVar.caF.bSZ);
        }
        return false;
    }
}
