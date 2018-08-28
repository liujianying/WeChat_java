package com.tencent.mm.plugin.appbrand.appcache.a.b;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.a.c.a;
import com.tencent.mm.plugin.appbrand.appcache.a.d.g;
import com.tencent.mm.protocal.c.chl;
import com.tencent.mm.protocal.c.cht;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends a<Boolean, cht> {
    public final /* synthetic */ Object b(String str, String str2, Object obj) {
        boolean z;
        cht cht = (cht) obj;
        com.tencent.mm.plugin.appbrand.appcache.a.d.h hVar = (com.tencent.mm.plugin.appbrand.appcache.a.d.h) e.x(com.tencent.mm.plugin.appbrand.appcache.a.d.h.class);
        int i = cht.sBM;
        int i2 = cht.sBu.sBs;
        if (bi.oW(str)) {
            z = false;
        } else {
            g gVar = new g();
            gVar.field_username = str;
            boolean b = hVar.b(gVar, new String[0]);
            gVar.field_appVersion = i;
            gVar.field_reportId = i2;
            z = b ? hVar.c(gVar, new String[0]) : hVar.b(gVar);
        }
        x.i("MicroMsg.AppBrand.Predownload.CmdUpdateVersion", "call, username %s, version %d, reportId %d, update %b", new Object[]{str, Integer.valueOf(cht.sBM), Integer.valueOf(cht.sBu.sBs), Boolean.valueOf(z)});
        int i3 = a.fiY;
        a.n((long) cht.sBu.sBs, z ? 155 : 156);
        return Boolean.valueOf(z);
    }

    final /* bridge */ /* synthetic */ chl bf(Object obj) {
        return ((cht) obj).sBu;
    }

    final String acp() {
        return "CmdUpdateVersion";
    }
}
