package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.px;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsTimeLineUI$7 extends c<px> {
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$7(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
        this.sFo = px.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        px pxVar = (px) bVar;
        if (!(SnsTimeLineUI.g(this.odw) == null || SnsTimeLineUI.g(this.odw).nLK == null)) {
            com.tencent.mm.plugin.sns.h.b bVar2 = SnsTimeLineUI.g(this.odw).nLK.nrb;
            bVar2.nxe.add(pxVar.caD.bSZ);
        }
        return false;
    }
}
