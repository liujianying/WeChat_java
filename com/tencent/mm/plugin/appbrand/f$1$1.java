package com.tencent.mm.plugin.appbrand;

import android.os.Build.VERSION;
import android.os.StatFs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.ah;
import com.tencent.mm.plugin.appbrand.appcache.h;
import com.tencent.mm.plugin.appbrand.appcache.h.b;
import com.tencent.mm.plugin.appbrand.appcache.h.c;
import com.tencent.mm.plugin.appbrand.appcache.k;
import com.tencent.mm.plugin.appbrand.appstorage.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.f.1;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.vending.c.a;

class f$1$1 implements a<Void, Void> {
    final /* synthetic */ 1 fcp;

    f$1$1(1 1) {
        this.fcp = 1;
    }

    public final /* synthetic */ Object call(Object obj) {
        long j = k.abH() ? AppBrandGlobalSystemConfig.adZ().fpZ.fqj : 86400;
        long longValue = ((Long) g.Ei().DT().get(aa.a.sTx, Long.valueOf(0))).longValue();
        long VE = bi.VE();
        if (VE >= longValue) {
            g.Ei().DT().a(aa.a.sTx, Long.valueOf(j + VE));
            c.abz().run();
            if (e.aaV() == null) {
                x.e("MicroMsg.AppBrand.IPkgCleanupLogic.Report", "reportStorageUsage, db not ready");
            } else {
                com.tencent.mm.g.b.a.k kVar = new com.tencent.mm.g.b.a.k();
                StatFs statFs = new StatFs(ah.abY());
                longValue = VERSION.SDK_INT >= 18 ? statFs.getBlockCountLong() : (long) statFs.getBlockCount();
                long aby = b.aby();
                double blockSizeLong = ((double) (aby / (VERSION.SDK_INT >= 18 ? statFs.getBlockSizeLong() : (long) statFs.getBlockSize()))) / ((double) longValue);
                kVar.cir = aby;
                kVar.cis = Math.round(blockSizeLong * 100.0d);
                statFs = new StatFs(com.tencent.mm.loader.stub.b.duN);
                kVar.cit = Math.round((((double) (VERSION.SDK_INT >= 18 ? statFs.getAvailableBlocksLong() : (long) statFs.getAvailableBlocks())) / ((double) (VERSION.SDK_INT >= 18 ? statFs.getBlockCountLong() : (long) statFs.getBlockCount()))) * 100.0d);
                kVar.ciu = k.abH() ? 1 : 0;
                kVar.civ = (long) h.e.abC();
                x.i("MicroMsg.AppBrand.IPkgCleanupLogic.Report", "reportStorageUsage %s", new Object[]{kVar.wF()});
                kVar.RD();
            }
            d.fjV.run();
        }
        return uQG;
    }
}
