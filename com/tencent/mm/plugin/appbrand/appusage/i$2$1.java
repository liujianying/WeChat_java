package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.plugin.appbrand.appusage.i.2;
import com.tencent.mm.protocal.c.ako;
import com.tencent.mm.sdk.platformtools.x;

class i$2$1 implements a {
    final /* synthetic */ 2 flI;

    i$2$1(2 2) {
        this.flI = 2;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        if (i == 0 && i2 == 0 && bVar != null && bVar.dIE.dIL != null && (bVar.dIE.dIL instanceof ako)) {
            i.a((ako) bVar.dIE.dIL);
        } else {
            x.e("MicroMsg.AppBrandNearbyLogic", "refresh() cgi return errType %d, errCode %d, errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            i.a(null);
        }
        return 0;
    }
}
