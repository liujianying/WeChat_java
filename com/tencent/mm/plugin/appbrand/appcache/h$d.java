package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.StatFs;
import com.tencent.mm.g.b.a.l;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.h.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class h$d implements h {
    public final void run() {
        if (e.abi() == null) {
            x.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "run() entered but storage not ready");
            return;
        }
        try {
            long VE;
            List<al> acm = e.abi().acm();
            if (!bi.cX(acm)) {
                VE = bi.VE();
                for (al alVar : acm) {
                    if (com.tencent.mm.plugin.appbrand.task.e.vD(alVar.field_appId)) {
                        x.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug appID(%s) is running, skip", new Object[]{alVar.field_appId});
                    } else if (alVar.field_endTime <= 0 || alVar.field_endTime > VE) {
                        if (alVar.field_debugType == 999) {
                            x.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug, debug library not exceed time range[%d %d]", new Object[]{Long.valueOf(alVar.field_startTime), Long.valueOf(alVar.field_endTime)});
                        }
                    } else if (alVar.field_debugType == 999) {
                        a.qD(alVar.field_pkgPath);
                        e.abi().a(alVar);
                        x.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug, (%s, %d) exceed time range[%d, %d]", new Object[]{alVar.field_appId, Integer.valueOf(alVar.field_debugType), Long.valueOf(alVar.field_startTime), Long.valueOf(alVar.field_endTime)});
                    }
                }
            }
            u.a aaV = e.aaV();
            int abL = ab.abL();
            if (abL <= 0) {
                WxaPkgWrappingInfo aG = com.tencent.mm.plugin.appbrand.launching.e.aG("@LibraryAppId", 0);
                abL = aG == null ? 0 : aG.fii;
            }
            if (abL > 0) {
                x.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, delete libraries record < %d", new Object[]{Integer.valueOf(abL)});
                e.abi().ak("@LibraryAppId", abL);
            }
            Cursor b = aaV.b("select distinct appId from AppBrandWxaPkgManifestRecord where debugType=? and appId!=? and appId not like '%%$%%'", new String[]{"0", "@LibraryAppId"}, 0);
            if (!(b == null || b.isClosed())) {
                List<String> linkedList = new LinkedList();
                if (b.moveToFirst()) {
                    do {
                        String string = b.getString(0);
                        if (com.tencent.mm.plugin.appbrand.task.e.vD(string)) {
                            x.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease appID(%s) is running, skip", new Object[]{string});
                        } else {
                            linkedList.add(string);
                        }
                    } while (b.moveToNext());
                }
                b.close();
                List linkedList2 = new LinkedList();
                for (String str : linkedList) {
                    WxaAttributes f = e.aba().f(str, new String[]{"versionInfo"});
                    if (f == null || bi.oW(f.field_versionInfo)) {
                        linkedList2.add(str);
                    } else {
                        if ((f.ael() == null ? 0 : f.ael().cbu) > 0) {
                            int ak = e.abi().ak(str, f.ael().cbu);
                            if (ak > 0) {
                                x.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, delete record(%s) < %d, count(%d)", new Object[]{str, Integer.valueOf(r1), Integer.valueOf(ak)});
                                l lVar = new l();
                                lVar.ciw = 2;
                                lVar.cix = str;
                                lVar.ciy = 0;
                                lVar.ciz = (long) ak;
                                lVar.ciu = 1;
                                lVar.RD();
                            }
                        }
                    }
                }
                ah(linkedList2);
            }
            abA();
            abB();
            StatFs statFs = new StatFs(ah.abY());
            VE = VERSION.SDK_INT >= 18 ? statFs.getBlockCountLong() : (long) statFs.getBlockCount();
            long aby = h$b.aby();
            double blockSizeLong = ((double) (aby / (VERSION.SDK_INT >= 18 ? statFs.getBlockSizeLong() : (long) statFs.getBlockSize()))) / ((double) VE);
            double d = (double) (((float) AppBrandGlobalSystemConfig.adZ().fpZ.fqm) / 100.0f);
            boolean z = blockSizeLong > d && aby > AppBrandGlobalSystemConfig.adZ().fpZ.fql * 1048576;
            x.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, usedPercent(%f), maxPercent(%f), usedBytes(%d), maxMB(%d), shouldCleanup=%B", new Object[]{Double.valueOf(blockSizeLong), Double.valueOf(d), Long.valueOf(aby), Long.valueOf(AppBrandGlobalSystemConfig.adZ().fpZ.fql), Boolean.valueOf(z)});
            if (z) {
                x.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, cleanup by conditions usedPercent(%f) > maxPercent(%f)", new Object[]{Double.valueOf(blockSizeLong), Double.valueOf(d)});
                long blockSizeLong2 = (long) (((double) (VERSION.SDK_INT >= 18 ? statFs.getBlockSizeLong() : (long) statFs.getBlockSize())) * (((double) VE) * (blockSizeLong - d)));
                if (blockSizeLong2 < 0) {
                    x.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, calculated bytesToTrim is minus");
                } else {
                    q.bL(blockSizeLong2);
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "process occur exception %s", new Object[]{e});
        }
    }

    private static void ah(List<String> list) {
        if (!bi.cX(list)) {
            long VE = bi.VE() - AppBrandGlobalSystemConfig.adZ().fpZ.fqk;
            for (String str : list) {
                WxaPkgWrappingInfo aG = com.tencent.mm.plugin.appbrand.launching.e.aG(str, 0);
                if (aG != null && TimeUnit.MILLISECONDS.toSeconds(new File(aG.ffK).lastModified()) < VE) {
                    x.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processReleaseWithoutContact, delete record(%s) < %d", new Object[]{str, Integer.valueOf(aG.fii)});
                    e.abi().ak(str, aG.fii);
                }
            }
        }
    }

    private static void abA() {
        long VE = bi.VE() - AppBrandGlobalSystemConfig.adZ().fpZ.fqk;
        Cursor axc = ((y) e.x(y.class)).axc();
        if (axc != null && !axc.isClosed()) {
            List<x> linkedList = new LinkedList();
            if (axc.moveToFirst()) {
                do {
                    x xVar = new x();
                    xVar.d(axc);
                    linkedList.add(xVar);
                } while (axc.moveToNext());
            }
            axc.close();
            for (x xVar2 : linkedList) {
                if (com.tencent.mm.a.e.cn(xVar2.field_pkgPath) && TimeUnit.MILLISECONDS.toSeconds(new File(xVar2.field_pkgPath).lastModified()) < VE) {
                    x.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processEncrypted, delete record(%s %d %d)", new Object[]{xVar2.field_appId, Integer.valueOf(xVar2.field_type), Integer.valueOf(xVar2.field_version)});
                    ((y) e.x(y.class)).a(xVar2, new String[0]);
                    com.tencent.mm.a.e.co(xVar2.field_pkgPath);
                }
            }
        }
    }

    private void abB() {
        File file = new File(ah.abY());
        if (file.exists() && file.isDirectory()) {
            for (File file2 : file.listFiles(new 1(this))) {
                if (!e.abi().qT(file2.getAbsolutePath())) {
                    a.qD(file2.getAbsolutePath());
                }
            }
        }
    }
}
