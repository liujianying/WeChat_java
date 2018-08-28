package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.ab.d;
import com.tencent.mm.g.a.or;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;

class g$1 implements a {
    final /* synthetic */ g qmg;

    g$1(g gVar) {
        this.qmg = gVar;
    }

    public final void a(d.a aVar) {
        String str = (String) bl.z(ab.a(aVar.dIN.rcl), "sysmsg").get(".sysmsg.pushloginurl.url");
        if (bi.oW(str)) {
            x.e("MicroMsg.SubCoreWebWX.pushloginurl", "pushloginurl is null");
        }
        or orVar = new or();
        orVar.bZC.bZD = str;
        orVar.bZC.type = 1;
        com.tencent.mm.sdk.b.a.sFg.m(orVar);
        aVar.dIN.rcp = null;
    }
}
