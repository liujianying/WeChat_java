package com.tencent.mm.plugin.appbrand.appcache.a.b;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.d.c;
import com.tencent.mm.plugin.appbrand.appcache.a.d.d;
import com.tencent.mm.plugin.appbrand.appcache.y;
import com.tencent.mm.plugin.appbrand.launching.e;
import com.tencent.mm.plugin.appbrand.launching.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import java.util.concurrent.atomic.AtomicBoolean;

class i$2 implements a<Void, Void> {
    final /* synthetic */ i fiU;
    final /* synthetic */ c fiV;

    i$2(i iVar, c cVar) {
        this.fiU = iVar;
        this.fiV = cVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        boolean z = true;
        WxaPkgWrappingInfo aG = e.aG(this.fiV.field_appId, 0);
        if (aG == null || aG.fii < this.fiV.field_version) {
            if (!this.fiV.field_firstTimeTried) {
                this.fiV.field_firstTimeTried = true;
                this.fiV.field_lastRetryTime = bi.VE();
                ((d) com.tencent.mm.plugin.appbrand.app.e.x(d.class)).c(this.fiV, new String[0]);
            } else if (this.fiV.field_retryTimes <= 0) {
                x.e("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "record(%s %d %d) retryTimes == 0, skip");
                ((d) com.tencent.mm.plugin.appbrand.app.e.x(d.class)).a(this.fiV, new String[0]);
            } else if (this.fiV.field_lastRetryTime + this.fiV.field_retryInterval > bi.VE()) {
                x.e("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "exceed record(%s %d %d) retryInterval %d, skip", new Object[]{this.fiV.field_appId, Integer.valueOf(this.fiV.field_type), Integer.valueOf(this.fiV.field_version), Long.valueOf(this.fiV.field_retryInterval)});
            } else if (this.fiV.field_retriedCount + 1 > this.fiV.field_retryTimes) {
                x.e("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "exceed record(%s %d %d) retryTimes %d, skip", new Object[]{this.fiV.field_appId, Integer.valueOf(this.fiV.field_type), Integer.valueOf(this.fiV.field_version), Integer.valueOf(this.fiV.field_retryTimes)});
                ((d) com.tencent.mm.plugin.appbrand.app.e.x(d.class)).a(this.fiV, new String[0]);
            } else {
                c cVar = this.fiV;
                cVar.field_retriedCount++;
                this.fiV.field_lastRetryTime = bi.VE();
                ((d) com.tencent.mm.plugin.appbrand.app.e.x(d.class)).c(this.fiV, new String[0]);
            }
            int i;
            if (this.fiV.field_type == 0) {
                com.tencent.mm.plugin.appbrand.app.e.abi().g(this.fiV.field_appId, this.fiV.field_version, this.fiV.field_pkgMd5);
                b cBF = g.cBF();
                cBF.cBE();
                i = this.fiV.field_reportId;
                if (this.fiV.field_retriedCount <= 0) {
                    z = false;
                }
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                p pVar = new p(this.fiV.field_appId, "", this.fiV.field_version, false);
                pVar.gfQ = new 1(this, z, i, atomicBoolean, cBF);
                pVar.prepareAsync();
            } else {
                y yVar = (y) com.tencent.mm.plugin.appbrand.app.e.x(y.class);
                com.tencent.mm.plugin.appbrand.appcache.x q = yVar.q(this.fiV.field_appId, this.fiV.field_type, this.fiV.field_version);
                if (q != null) {
                    boolean a = f.a(q, f.a.fiO);
                    x.i("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "record(%s %d %d) integrated, decryptResult %b", new Object[]{this.fiV.field_appId, Integer.valueOf(this.fiV.field_type), Integer.valueOf(this.fiV.field_version), Boolean.valueOf(a)});
                } else {
                    String str = this.fiV.field_appId;
                    i = this.fiV.field_type;
                    int i2 = this.fiV.field_version;
                    String str2 = this.fiV.field_pkgMd5;
                    com.tencent.mm.plugin.appbrand.appcache.x xVar = new com.tencent.mm.plugin.appbrand.appcache.x();
                    xVar.field_appId = str;
                    xVar.field_type = i;
                    xVar.field_version = i2;
                    z = yVar.b(xVar, new String[0]);
                    xVar.field_pkgMd5 = str2;
                    if (z) {
                        yVar.c(xVar, new String[0]);
                    } else {
                        yVar.b(xVar);
                    }
                    b cBF2 = g.cBF();
                    cBF2.cBE();
                    com.tencent.mm.by.g.cC(this.fiV).j(new com.tencent.mm.plugin.appbrand.appcache.a.a.a()).g(new 2(this, cBF2));
                }
            }
        } else {
            x.i("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "available pkg(%s %d) >= record(%s %d), skip", new Object[]{this.fiV.field_appId, Integer.valueOf(aG.fii), this.fiV.field_appId, Integer.valueOf(this.fiV.field_version)});
            ((d) com.tencent.mm.plugin.appbrand.app.e.x(d.class)).a(this.fiV, new String[0]);
        }
        return null;
    }
}
