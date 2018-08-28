package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.ab.a;
import com.tencent.mm.ab.b;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.protocal.c.cgx;
import com.tencent.mm.protocal.c.cgz;
import com.tencent.mm.sdk.platformtools.bi;

public final class l extends a<cgz> {
    final b diG;

    public l(String str, String str2) {
        com.tencent.mm.bk.b bVar;
        b.a aVar = new b.a();
        cgx cgx = new cgx();
        cgx.spJ = str;
        if (bi.oW(str)) {
            WxaAttributes f = e.aba().f(str2, "syncVersion");
            bVar = new com.tencent.mm.bk.b((f == null ? "" : bi.oV(f.field_syncVersion)).getBytes());
        } else {
            bVar = r.sd(str);
        }
        cgx.riB = bVar;
        cgx.sBg = str2;
        aVar.dIG = cgx;
        aVar.dIH = new cgz();
        aVar.dIF = 1151;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaattr/wxaattrsync";
        b KT = aVar.KT();
        this.diG = KT;
        this.diG = KT;
    }
}
