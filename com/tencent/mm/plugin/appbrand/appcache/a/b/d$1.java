package com.tencent.mm.plugin.appbrand.appcache.a.b;

import com.tencent.mm.ab.a$a;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.protocal.c.cgz;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

class d$1 implements a<Void, a$a<cgz>> {
    final /* synthetic */ String dhF;
    final /* synthetic */ b fiG;
    final /* synthetic */ int fiJ;
    final /* synthetic */ d fiK;

    d$1(d dVar, String str, b bVar, int i) {
        this.fiK = dVar;
        this.dhF = str;
        this.fiG = bVar;
        this.fiJ = i;
    }

    public final /* synthetic */ Object call(Object obj) {
        long j;
        long j2;
        a$a a_a = (a$a) obj;
        x.i("MicroMsg.AppBrand.Predownload.CmdGetContact", "getContact(%s) back, errType %d, errCode %d, errMsg %s", new Object[]{this.dhF, Integer.valueOf(a_a.errType), Integer.valueOf(a_a.errCode), a_a.Yy});
        if (com.tencent.mm.plugin.appbrand.j.a.b(a_a)) {
            boolean a = e.aba().a(this.dhF, ((cgz) a_a.dIv).riB, ((cgz) a_a.dIv).riC);
            this.fiG.v(new Object[]{Boolean.valueOf(true)});
            int i = com.tencent.mm.plugin.appbrand.appcache.a.c.a.fiY;
            j = (long) this.fiJ;
            j2 = a ? 25 : 27;
        } else {
            this.fiG.v(new Object[]{Boolean.valueOf(false)});
            int i2 = com.tencent.mm.plugin.appbrand.appcache.a.c.a.fiY;
            j = (long) this.fiJ;
            j2 = 26;
        }
        com.tencent.mm.plugin.appbrand.appcache.a.c.a.n(j, j2);
        return uQG;
    }
}
