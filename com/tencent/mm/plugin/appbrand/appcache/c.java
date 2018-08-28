package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.a.o;
import com.tencent.mm.ab.a;
import com.tencent.mm.ab.b;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.launching.h;
import com.tencent.mm.protocal.c.aim;
import com.tencent.mm.protocal.c.ain;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.v.g;

public final class c extends a<ain> {
    private final b diG;

    public c(String str, String str2, String str3, int i) {
        b.a aVar = new b.a();
        aVar.dIF = 1718;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/gettestcodedownloadinfo";
        aim aim = new aim();
        aim.bPS = str;
        aim.rLl = str2;
        aim.rLm = str3;
        aim.rnc = i;
        if (i == 1) {
            try {
                aim.rLn = new o(g.fU(((h) e.x(h.class)).aH(str, i)).optLong("dev_key")).intValue();
            } catch (Exception e) {
                x.e("MicroMsg.AppBrand.CgiGetTestCodeDownloadInfo", "opt devKey %s", new Object[]{e});
            }
        }
        aVar.dIG = aim;
        aVar.dIH = new ain();
        b KT = aVar.KT();
        this.diG = KT;
        this.diG = KT;
    }
}
