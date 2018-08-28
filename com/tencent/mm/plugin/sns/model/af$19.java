package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.nv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class af$19 extends c<nv> {
    final /* synthetic */ af nqT;

    af$19(af afVar) {
        this.nqT = afVar;
        this.sFo = nv.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.d("MicroMsg.SnsCore", "try resend msg for SnsInfoId:%d", new Object[]{Long.valueOf((long) ((nv) bVar).bYQ.bYR)});
        ah.A(new 1(this, r0));
        return false;
    }
}
