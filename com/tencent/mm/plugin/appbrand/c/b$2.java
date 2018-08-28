package com.tencent.mm.plugin.appbrand.c;

import com.tencent.mm.modelcdntran.j.a;
import com.tencent.mm.plugin.appbrand.c.d.c;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements a {
    final /* synthetic */ b fnW;

    b$2(b bVar) {
        this.fnW = bVar;
    }

    public final void onMoovReady(String str, int i, int i2) {
        x.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on moov ready [%s %d %d]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        c cVar = (c) this.fnW.fnU.get(str);
        if (cVar != null) {
            cVar.bB(i, i2);
        }
    }

    public final void onDataAvailable(String str, int i, int i2) {
        x.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on data available [%s %d %d]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        c cVar = (c) this.fnW.fnU.get(str);
        if (cVar != null) {
            cVar.bC(i, i2);
        }
    }

    public final void h(String str, int i, int i2) {
        x.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on progress [%s %d %d]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        c cVar = (c) this.fnW.fnU.get(str);
        if (cVar != null) {
            cVar.bD(i, i2);
        }
    }

    public final void L(String str, int i) {
        x.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on finish [%s %d]", new Object[]{str, Integer.valueOf(i)});
        c cVar = (c) this.fnW.fnU.get(str);
        if (cVar != null) {
            cVar.L(str, i);
        }
    }
}
