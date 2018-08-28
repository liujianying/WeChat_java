package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.protocal.c.aks;
import com.tencent.mm.sdk.platformtools.x;

class e$1 implements a {
    final /* synthetic */ e flm;

    e$1(e eVar) {
        this.flm = eVar;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        if (i == 0 && i2 == 0 && bVar != null && bVar.dIE.dIL != null && (bVar.dIE.dIL instanceof aks)) {
            e.a(this.flm, (aks) bVar.dIE.dIL);
        } else {
            x.e("MicroMsg.AppBrandLauncherListWAGameLogic", "doRequest() cgi return errType %d, errCode %d, errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            e.a(this.flm, null);
        }
        return 0;
    }
}
