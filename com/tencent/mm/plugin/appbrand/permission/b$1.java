package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.mm.ab.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.c.aph;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    final /* synthetic */ int gpV;
    final /* synthetic */ b gpW;

    b$1(b bVar, int i) {
        this.gpW = bVar;
        this.gpV = i;
    }

    public final void a(int i, int i2, String str, b bVar) {
        if (i != 0 || i2 != 0 || bVar.dIE.dIL == null) {
            x.e("MicroMsg.AppBrandJsApiUserAuth", "setAuth, cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, bVar.dIE.dIL);
        } else if (((aph) bVar.dIE.dIL).rRd.bMH == 0 && 1 == this.gpV) {
            x.i("MicroMsg.AppBrandJsApiUserAuth", "setAuth, add allow cache appId = %s, api = %s", b.a(this.gpW), b.b(this.gpW));
            b.amj().put(b.a(this.gpW), b.b(this.gpW));
        }
    }
}
