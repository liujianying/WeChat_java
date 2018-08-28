package com.tencent.mm.plugin.appbrand.appcache;

import android.os.SystemClock;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.base.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.base.a;
import com.tencent.mm.plugin.appbrand.appcache.base.b;
import com.tencent.mm.pluginsdk.g.a.c.c;
import com.tencent.mm.pluginsdk.g.a.c.e;
import com.tencent.mm.pluginsdk.g.a.c.k;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

final class ah$d implements c {
    final /* synthetic */ ah fho;
    final ag fhs = new ag(new ah("WxaPkgDownloadPerformerEventDispatchThread").lnJ.getLooper());

    ah$d(ah ahVar) {
        this.fho = ahVar;
    }

    public final void a(e eVar, m mVar) {
        this.fhs.post(new 1(this, mVar, eVar));
    }

    public final void s(String str, int i, int i2) {
    }

    public final void t(String str, long j) {
    }

    public static void b(e eVar, m mVar) {
        a((ah.c) eVar, mVar);
    }

    public static void c(e eVar, m mVar) {
        a abZ = ((ah.c) eVar).abZ();
        if (abZ instanceof ae) {
            ae aeVar = (ae) abZ;
            s.a aVar = ((ah.c) eVar).fhr;
            ap aaN = ((com.tencent.mm.plugin.appbrand.a.c) g.l(com.tencent.mm.plugin.appbrand.a.c.class)).aaN();
            if (aaN == null) {
                aq.a(aeVar.qBy, aeVar.appId, b.a.a.fiv, null);
                return;
            }
            String str = aeVar.appId;
            int i = aeVar.fgJ;
            int i2 = aeVar.fgK;
            String abR = aeVar.abR();
            al a = aaN.a(str, i, 0, new String[]{"pkgPath"});
            al a2 = aaN.a(str, i2, 0, new String[]{"versionMd5"});
            if (a == null || a2 == null) {
                aq.a(aeVar.qBy, aeVar.appId, b.a.a.fiv, null);
                return;
            }
            aVar.abv();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int z = i.z(a.field_pkgPath, abR, aeVar.getFilePath());
            elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
            x.i("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "applyPkgPatch, appId[%s], oldPath[%s], newPath[%s], patchPath[%s], cost %d, ret %d", new Object[]{aeVar.appId, a.field_pkgPath, abR, aeVar.getFilePath(), Long.valueOf(elapsedRealtime), Integer.valueOf(z)});
            aVar.jD(z);
            if (z == 0) {
                aq.a(aeVar.qBy, aeVar.appId, abR, i2, 0, aVar);
                return;
            }
            com.tencent.mm.a.e.deleteFile(abR);
            al a3 = aaN.a(aeVar.appId, aeVar.fgK, 0, new String[]{"downloadURL"});
            if (a3 == null) {
                aq.a(aeVar.qBy, aeVar.appId, b.a.a.fiv, null);
                return;
            }
            aq.qV(aeVar.qBy);
            aq.b(aeVar.appId, 0, aeVar.fgK, a3.field_downloadURL, aeVar.fgL);
        } else if (abZ instanceof f) {
            e eVar2 = e.fft;
            f fVar = (f) abZ;
            s.a aVar2 = ((ah.c) eVar).fhr;
            eVar2.a(fVar, mVar);
        } else {
            String str2 = ((ah.c) eVar).abZ().appId;
            try {
                aq.a(mVar.qBy, str2, mVar.filePath, ((ah.c) eVar).abZ().version, ((ah.c) eVar).abZ().bPh, ((ah.c) eVar).fhr);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrandWxaPkgDownloadPerformer", e, "dispatchComplete", new Object[0]);
                aq.aS(mVar.qBy, str2);
            }
        }
    }

    public static void d(e eVar, m mVar) {
        a((ah.c) eVar, mVar);
    }

    public final void a(String str, k kVar) {
        aq.a(str, (WxaPkgLoadProgress) kVar);
    }

    private static void a(ah.c cVar, m mVar) {
        com.tencent.mm.a.e.deleteFile(mVar.filePath);
        if (cVar.abZ() instanceof f) {
            e eVar = e.fft;
            f fVar = (f) cVar.abZ();
            s.a aVar = cVar.fhr;
            eVar.a(fVar, mVar);
        } else if (cVar.abZ() instanceof ae) {
            ae aeVar = (ae) cVar.abZ();
            s.a aVar2 = cVar.fhr;
            x.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, request(%s %d->%d)", new Object[]{aeVar.appId, Integer.valueOf(aeVar.fgJ), Integer.valueOf(aeVar.fgK)});
            aVar2.a(mVar);
            ap aaN = ((com.tencent.mm.plugin.appbrand.a.c) g.l(com.tencent.mm.plugin.appbrand.a.c.class)).aaN();
            if (aaN == null) {
                x.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil storage");
                aq.a(aeVar.qBy, aeVar.appId, b.a.a.fiv, null);
                return;
            }
            aq.qV(aeVar.qBy);
            al a = aaN.a(aeVar.appId, aeVar.fgK, 0, new String[]{"downloadURL"});
            if (a == null) {
                x.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil record(%s %d)", new Object[]{aeVar.appId, Integer.valueOf(aeVar.fgK)});
                return;
            }
            aq.b(aeVar.appId, 0, aeVar.fgK, a.field_downloadURL, aeVar.fgL);
        } else {
            b.a.a aVar3;
            String str = cVar.abZ().appId;
            if (!(mVar.qDk instanceof com.tencent.mm.pluginsdk.g.a.b.a)) {
                switch (mVar.httpStatusCode) {
                    case 403:
                    case 404:
                        aVar3 = b.a.a.fit;
                        break;
                    default:
                        aVar3 = b.a.a.fip;
                        break;
                }
            }
            aVar3 = b.a.a.fiu;
            aq.a(mVar.qBy, str, aVar3);
        }
    }
}
