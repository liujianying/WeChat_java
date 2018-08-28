package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public enum ak {
    ;

    public static Pair<a, WxaPkgWrappingInfo> cw(boolean z) {
        return p(z, false);
    }

    public static Pair<a, WxaPkgWrappingInfo> p(boolean z, boolean z2) {
        if (z && !(z2 && af.fgN == af$a.DEVELOP)) {
            c cVar = (c) g.l(c.class);
            if (cVar != null) {
                ap aaN = cVar.aaN();
                if (aaN != null) {
                    Object obj;
                    int aj = aaN.aj("@LibraryAppId", 0);
                    if (!"@LibraryAppId".equals("@LibraryAppId") || (aj >= 0 && af.VERSION < aj)) {
                        obj = null;
                    } else {
                        x.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "use local library version = %d | query appId = %s, debugType = %d, pkgVersion = %d", new Object[]{Integer.valueOf(af.VERSION), r0, Integer.valueOf(0), Integer.valueOf(aj)});
                        obj = af.abV();
                    }
                    if (obj != null) {
                        x.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkLibrary, dbMax %d, local %d, use local", new Object[]{Integer.valueOf(aj), Integer.valueOf(af.VERSION)});
                        return Pair.create(a.fhB, obj);
                    }
                }
            }
            return Pair.create(a.fhB, af.abV());
        }
        x.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkLibrary, release %b, skipLocalDevPack %b, localPackMode %s, checkRecordResult %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), af.fgN, t("@LibraryAppId", z ? 0 : 999, -1).first});
        return t("@LibraryAppId", z ? 0 : 999, -1);
    }

    public static Pair<a, WxaPkgWrappingInfo> t(String str, int i, int i2) {
        if (!g.Eg().dpD || ((c) g.l(c.class)).aaN() == null) {
            x.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null storage, appId = %s, debugType = %d, version = %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
            return Pair.create(a.fhG, null);
        }
        al a;
        String[] strArr = new String[]{"pkgPath", "versionMd5", "version", "createTime"};
        if (!a.jC(i) || i2 <= 0) {
            a = ((c) g.l(c.class)).aaN().a(str, i, strArr);
        } else {
            a = ((c) g.l(c.class)).aaN().a(str, i2, i, strArr);
        }
        if (a == null) {
            x.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null record, appId = %s, debugType = %d, version = %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
            return Pair.create(a.fhC, null);
        }
        int i3;
        if (i == 999) {
            x.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkPkg for dev_lib, time_scope[%d, %d]", new Object[]{Long.valueOf(a.field_startTime), Long.valueOf(a.field_endTime)});
            if (a.field_endTime > 0 && a.field_endTime <= bi.VE()) {
                return Pair.create(a.fhD, null);
            }
        }
        String str2 = a.field_pkgPath;
        String str3 = a.field_versionMd5;
        if (i2 < 0) {
            i3 = a.field_version;
        } else {
            i3 = i2;
        }
        long j = a.field_createTime;
        if (bi.oW(str2) || !e.cn(str2)) {
            x.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "file not exists, pkgPath = %s, appId = %s, debugType = %d, version = %d", new Object[]{str2, str, Integer.valueOf(i), Integer.valueOf(i3)});
            return Pair.create(a.fhF, null);
        }
        String cu = com.tencent.mm.a.g.cu(str2);
        if (bi.oW(str3) || str3.equals(cu)) {
            WxaPkgWrappingInfo qX = WxaPkgWrappingInfo.qX(str2);
            if (qX == null) {
                x.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "obtain wxPkg failed, appId = %s, debugType = %d, version = %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
                return Pair.create(a.fhF, null);
            }
            qX.fii = i3;
            qX.fij = j;
            qX.ffK = str2;
            qX.fik = false;
            qX.fih = i;
            qX.bKg = cu;
            x.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "check ok, params: appId = %s, debugType = %d, version = %d, pkgVersion = %d, startTime = %d, endTime = %d, return %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(a.field_startTime), Long.valueOf(a.field_endTime), qX});
            return Pair.create(a.fhB, qX);
        }
        x.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "md5 mismatch | realMd5 = %s, manifestMd5 = %s, appId = %s, debugType = %d, version = %d", new Object[]{cu, str3, str, Integer.valueOf(i), Integer.valueOf(i2)});
        return Pair.create(a.fhF, null);
    }
}
