package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.appcache.base.b;
import com.tencent.mm.plugin.appbrand.appcache.base.b.a;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.pluginsdk.g.a.c.k;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Set;

public enum e implements b<f, m, k> {
    ;
    
    public final g<String, a<m, k>> ffu;

    private e(String str) {
        this.ffu = new g();
    }

    public final void a(f fVar, m mVar) {
        a.a aVar;
        if (mVar.status != 2) {
            x.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult %s", new Object[]{mVar});
            if (!(mVar.qDk instanceof com.tencent.mm.pluginsdk.g.a.b.a)) {
                switch (mVar.httpStatusCode) {
                    case 403:
                    case 404:
                        aVar = a.a.fit;
                        break;
                    default:
                        aVar = a.a.fip;
                        break;
                }
            }
            aVar = a.a.fiu;
        } else {
            a.a aVar2;
            y aaO = ((c) com.tencent.mm.kernel.g.l(c.class)).aaO();
            if (aaO == null) {
                x.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, null storage");
                aVar2 = a.a.fiv;
            } else {
                x p = aaO.p(fVar.appId, fVar.ffw, fVar.version);
                if (p == null) {
                    x.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, null record with %s", new Object[]{fVar.toShortString()});
                    aVar2 = a.a.fiv;
                } else {
                    p.field_pkgPath = fVar.getFilePath();
                    x.i("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, integrityOk %b, with %s", new Object[]{Boolean.valueOf(y.a(p)), fVar.toShortString()});
                    if (y.a(p)) {
                        aaO.c(p, new String[0]);
                        aVar2 = a.a.fio;
                    } else {
                        aVar2 = a.a.fir;
                    }
                }
            }
            aVar = aVar2;
        }
        Set<a> bp = this.ffu.bp(fVar.qBy);
        if (bp != null) {
            for (a a : bp) {
                a.a(fVar.appId, aVar, mVar);
            }
        }
    }
}
