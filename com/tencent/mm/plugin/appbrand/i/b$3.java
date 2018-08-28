package com.tencent.mm.plugin.appbrand.i;

import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appcache.base.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.i.a.d;
import com.tencent.mm.plugin.appbrand.i.b.a;
import com.tencent.mm.plugin.appbrand.launching.RuntimeLoadModuleTask;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

class b$3 extends RuntimeLoadModuleTask {
    final /* synthetic */ String fdZ;
    final /* synthetic */ b gkt;
    final /* synthetic */ h gku;

    b$3(b bVar, String str, int i, int i2, String str2, String str3, h hVar) {
        this.gkt = bVar;
        this.fdZ = str3;
        this.gku = hVar;
        super(str, i, i2, str2);
    }

    public final void un(String str) {
        int i = 0;
        x.i("MicroMsg.AppBrand.RuntimeModularizingHelper", "onLoad, module(%s) pkgPath(%s)", new Object[]{this.fdZ, str});
        if (!bi.oW(str)) {
            i = 1;
        }
        if (i != 0) {
            Iterator it = this.gkt.fdD.fcu.frm.fil.iterator();
            while (it.hasNext()) {
                ModulePkgInfo modulePkgInfo = (ModulePkgInfo) it.next();
                if (this.fdZ.equals(modulePkgInfo.name)) {
                    modulePkgInfo.ffK = str;
                    break;
                }
            }
            ao.l(this.gkt.fdD);
            this.gkt.uC(this.fdZ);
        }
        ah.A(new 1(this));
        b.a(this.gkt, this.fdZ, i != 0 ? d.gki : d.gkj);
    }

    public final void b(WxaPkgLoadProgress wxaPkgLoadProgress) {
        x.i("MicroMsg.AppBrand.RuntimeModularizingHelper", "hy: on load module progress %s", new Object[]{wxaPkgLoadProgress});
        b bVar = this.gkt;
        String str = this.fdZ;
        synchronized (bVar.gkn) {
            for (a aVar : bVar.gkn.bo(str)) {
                if (aVar.gky != null) {
                    aVar.gky.a(wxaPkgLoadProgress);
                }
            }
        }
    }
}
