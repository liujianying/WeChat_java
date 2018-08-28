package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.mm.ab.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.c.apf;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements a {
    final /* synthetic */ b gpW;

    b$2(b bVar) {
        this.gpW = bVar;
    }

    public final void a(int i, int i2, String str, b bVar) {
        if (i == 0 && i2 == 0 && bVar.dIE.dIL != null) {
            b.a(this.gpW, (apf) bVar.dIE.dIL);
            return;
        }
        x.e("MicroMsg.AppBrandJsApiUserAuth", "checkAuth, cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.dIE.dIL});
        b.amj().F(b.a(this.gpW), b.b(this.gpW));
        b.c(this.gpW).amm();
    }
}
