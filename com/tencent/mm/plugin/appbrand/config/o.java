package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.config.k.a;
import com.tencent.mm.plugin.appbrand.n.c;
import com.tencent.mm.plugin.appbrand.n.c$a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class o implements c {
    public final WxaAttributes rR(String str) {
        return e.aba().e(str, new String[0]);
    }

    public final void a(String str, c$a c_a) {
        r.a(str, false, new 1(this, c_a));
    }

    public final void b(String str, c$a c_a) {
        if (!bi.oW(str)) {
            ah ahVar = new ah();
            new ag(ahVar.lnJ.getLooper()).post(new 2(this, str, c_a, ahVar));
        } else if (c_a != null) {
            c_a.b(null);
        }
    }

    public final void al(List<String> list) {
        if (!bi.cX(list)) {
            x.i("MicroMsg.AppBrand.WxaAttrExportService", "batchSync list %s", new Object[]{bi.c(list, ", ")});
            r.a(list, a.frs);
        }
    }
}
