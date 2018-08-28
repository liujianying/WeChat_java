package com.tencent.mm.modelsimple;

import com.tencent.mm.g.a.a;
import com.tencent.mm.modelsimple.k.1;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class k$1$1 extends c<a> {
    final /* synthetic */ String efr;
    final /* synthetic */ String efs;
    final /* synthetic */ 1 eft;

    k$1$1(1 1, String str, String str2) {
        this.eft = 1;
        this.efr = str;
        this.efs = str2;
        this.sFo = a.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        com.tencent.mm.sdk.b.a.sFg.c(k.b(this.eft.efq));
        k.a(this.eft.efq, null);
        x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony after 5s[%b]", new Object[]{Boolean.valueOf(ad.chV())});
        ah.i(new 1(this), 5000);
        return true;
    }
}
