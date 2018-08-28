package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.cgl;
import com.tencent.mm.protocal.c.cgw;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class ap {
    public static final String[] fhX = new String[]{i.a(al.dzU, "AppBrandWxaPkgManifestRecord")};
    public final h fhY;
    public final b fhZ;

    private static final class b extends i<al> {
        b(e eVar) {
            super(eVar, al.dzU, "AppBrandWxaPkgManifestRecord", al.ciG);
        }
    }

    public ap(h hVar) {
        this.fhY = hVar;
        this.fhZ = new b(hVar);
    }

    public final int[] qS(String str) {
        if (bi.oW(str)) {
            return null;
        }
        if (!a.jC(0)) {
            return null;
        }
        List<al> a = a(str, 0, a.fia, "version");
        if (bi.cX(a)) {
            return null;
        }
        int[] iArr = new int[a.size()];
        int i = 0;
        for (al alVar : a) {
            int i2 = i + 1;
            iArr[i] = alVar.field_version;
            i = i2;
        }
        return iArr;
    }

    final List<al> a(String str, int i, a aVar, String... strArr) {
        if (bi.oW(str)) {
            return Collections.emptyList();
        }
        Cursor a = this.fhY.a("AppBrandWxaPkgManifestRecord", strArr, String.format(Locale.US, "%s=? and %s=? ", new Object[]{"appId", "debugType"}), new String[]{str, String.valueOf(i)}, null, null, "version " + aVar.name(), 2);
        if (a == null) {
            return Collections.emptyList();
        }
        if (a.moveToFirst()) {
            List<al> linkedList = new LinkedList();
            do {
                al alVar = new al();
                alVar.d(a);
                alVar.field_appId = str;
                alVar.field_debugType = i;
                linkedList.add(alVar);
            } while (a.moveToNext());
            a.close();
            return linkedList;
        }
        a.close();
        return Collections.emptyList();
    }

    public final al a(String str, int i, String... strArr) {
        al alVar = null;
        if (!bi.oW(str)) {
            String str2;
            String[] strArr2;
            if (a.jC(i)) {
                str2 = "version desc";
            } else if (a.ho(i)) {
                str2 = "createTime desc";
            } else {
                throw new RuntimeException("Illegal pkgType " + i);
            }
            h hVar = this.fhY;
            String str3 = "AppBrandWxaPkgManifestRecord";
            if (bi.G(strArr)) {
                strArr2 = null;
            } else {
                strArr2 = strArr;
            }
            Cursor query = hVar.query(str3, strArr2, String.format(Locale.US, "%s=? and %s=?", new Object[]{"appId", "debugType"}), new String[]{str, String.valueOf(i)}, null, null, str2);
            if (query != null) {
                if (query.moveToFirst()) {
                    alVar = new al();
                    alVar.d(query);
                    alVar.field_appId = str;
                    alVar.field_debugType = i;
                }
                query.close();
            }
        }
        return alVar;
    }

    final boolean qT(String str) {
        Cursor a = this.fhY.a("AppBrandWxaPkgManifestRecord", new String[]{"appId"}, String.format("%s=?", new Object[]{"pkgPath"}), new String[]{str}, null, null, null, 2);
        if (a == null) {
            return false;
        }
        boolean moveToFirst = a.moveToFirst();
        a.close();
        return moveToFirst;
    }

    final boolean a(cgl cgl, PInt pInt) {
        if (cgl.version < 0 || bi.oW(cgl.url) || bi.oW(cgl.bKg)) {
            x.e("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, invalid resp: version( %d ), url( %s ), md5( %s )", new Object[]{Integer.valueOf(cgl.version), cgl.url, cgl.bKg});
            return false;
        }
        if (cgl.seJ > 0) {
            x.i("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, delete manifest.version > %d, ret = %d", new Object[]{Integer.valueOf(cgl.version), Integer.valueOf(this.fhY.delete("AppBrandWxaPkgManifestRecord", String.format("%s=? and %s=? and %s>?", new Object[]{"appId", "debugType", "version"}), new String[]{"@LibraryAppId", "0", String.valueOf(cgl.version)}))});
            pInt.value = r0;
        }
        return a("@LibraryAppId", 0, cgl.version, cgl.bKg, cgl.url);
    }

    @SuppressLint({"DefaultLocale"})
    final List<al> qU(String str) {
        List<al> list = null;
        if (!bi.oW(str)) {
            Object format;
            if (a.jC(0)) {
                format = String.format("order by %s desc", new Object[]{"version"});
            } else {
                String format2 = String.format("order by %s desc", new Object[]{"createTime"});
            }
            String format3 = String.format("limit %d offset %d", new Object[]{Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(2)});
            Cursor a = this.fhY.a("AppBrandWxaPkgManifestRecord", new String[]{"pkgPath", "version"}, String.format("%s=? and %s=? %s %s", new Object[]{"appId", "debugType", format2, format3}), new String[]{str, "0"}, null, null, null, 2);
            if (a != null) {
                list = new ArrayList();
                if (a.moveToFirst()) {
                    do {
                        al alVar = new al();
                        alVar.field_appId = str;
                        alVar.field_debugType = 0;
                        alVar.d(a);
                        list.add(alVar);
                    } while (a.moveToNext());
                }
                a.close();
            }
        }
        return list;
    }

    public final boolean ah(String str, int i) {
        if (bi.oW(str) || i < 0) {
            return false;
        }
        Cursor a = this.fhY.a("AppBrandWxaPkgManifestRecord", new String[]{"version"}, String.format(Locale.US, "%s=? and %s=?", new Object[]{"appId", "debugType"}), new String[]{str, String.valueOf(i)}, null, null, null, 2);
        if (a == null) {
            return false;
        }
        boolean moveToFirst = a.moveToFirst();
        a.close();
        return moveToFirst;
    }

    public final boolean a(String str, int i, String str2, String str3, long j, long j2) {
        if (bi.oW(str)) {
            x.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaDebugAppVersionInfo, null or nil appId");
            return false;
        }
        x.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaDebugAppVersionInfo, appId %s, type %d, url %s, md5 %s, lifespan[%d, %d]", new Object[]{str, Integer.valueOf(i), str2, str3, Long.valueOf(j), Long.valueOf(j2)});
        if (i == 999) {
            str = "@LibraryAppId";
        }
        al a = a(str, 1, i, new String[0]);
        if (a == null) {
            al alVar = new al();
            alVar.field_appId = str;
            alVar.field_version = 1;
            alVar.field_debugType = i;
            alVar.field_downloadURL = str2;
            alVar.field_versionMd5 = str3;
            alVar.field_versionState = 0;
            alVar.field_startTime = j;
            alVar.field_endTime = j2;
            alVar.field_createTime = bi.VE();
            b(alVar);
            return true;
        }
        int i2;
        int i3;
        if (bi.oW(str3) || bi.oW(a.field_versionMd5) || str3.equals(a.field_versionMd5)) {
            boolean i22 = false;
        } else {
            i22 = 1;
        }
        if (str2.equals(a.field_downloadURL)) {
            boolean i32 = false;
        } else {
            i32 = 1;
        }
        if (i22 != 0) {
            a.field_downloadURL = str2;
            com.tencent.mm.a.e.deleteFile(a.field_pkgPath);
            a.field_pkgPath = null;
            a.field_createTime = bi.VE();
            a.field_versionMd5 = str3;
            a.field_startTime = j;
            a.field_endTime = j2;
            c(a);
            u(str, i, 1);
            return true;
        } else if (i32 == 0) {
            return false;
        } else {
            a.field_downloadURL = str2;
            a.field_startTime = j;
            a.field_endTime = j2;
            c(a);
            return false;
        }
    }

    public final boolean a(al alVar) {
        boolean z = !bi.oW(alVar.field_appId) && this.fhZ.a(alVar, al.fhI);
        if (z) {
            u(alVar.field_appId, alVar.field_debugType, alVar.field_version);
        }
        return z;
    }

    final List<al> acm() {
        List<al> list = null;
        StringBuilder stringBuilder = new StringBuilder("debugType");
        stringBuilder.append(" in (");
        for (int append : d.ffr) {
            stringBuilder.append(append).append(',');
        }
        stringBuilder.append(-1).append(')');
        Cursor a = this.fhY.a("AppBrandWxaPkgManifestRecord", null, stringBuilder.toString(), null, null, null, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                list = new ArrayList();
                do {
                    al alVar = new al();
                    alVar.d(a);
                    list.add(alVar);
                } while (a.moveToNext());
                a.close();
            } else {
                a.close();
            }
        }
        return list;
    }

    public final String ai(String str, int i) {
        al a = a(str, i, "downloadURL");
        return a == null ? "" : a.field_downloadURL;
    }

    public final int aj(String str, int i) {
        if (bi.oW(str) || !a.jC(i)) {
            return 0;
        }
        al a = a(str, i, "version");
        if (a != null) {
            return a.field_version;
        }
        return 0;
    }

    private boolean a(String str, int i, int i2, String str2, String str3) {
        if (!a.jC(i)) {
            return false;
        }
        x.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo for release, appId %s, type %d, version %d, md5 %s, url %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2, str3});
        int aj = aj(str, i);
        if (i2 < aj) {
            x.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, newVersion( %d ) < curMaxVersion( %d ), skip", new Object[]{Integer.valueOf(i2), Integer.valueOf(aj)});
            return false;
        } else if ("@LibraryAppId".equals(str) && i2 == af.VERSION) {
            x.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, given version == local library version %d, skip", new Object[]{Integer.valueOf(af.VERSION)});
            return false;
        } else {
            al a = a(str, i2, i, new String[0]);
            boolean z = false;
            if (a == null) {
                al alVar = new al();
                alVar.field_appId = str;
                alVar.field_version = i2;
                alVar.field_versionMd5 = str2;
                alVar.field_downloadURL = str3;
                alVar.field_debugType = i;
                x.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, insert record %b, appId %s, version %d, url %s, md5 %s", new Object[]{Boolean.valueOf(b(alVar)), str, Integer.valueOf(alVar.field_version), alVar.field_downloadURL, alVar.field_versionMd5});
                return b(alVar);
            }
            Object obj;
            String str4 = a.field_downloadURL;
            String str5 = a.field_versionMd5;
            if (!bi.oV(a.field_versionMd5).equals(str2)) {
                a.field_versionMd5 = str2;
                a.field_version = i2;
                a.field_downloadURL = str3;
                obj = 1;
            } else if (bi.oW(str3) || str3.equals(a.field_downloadURL)) {
                obj = null;
            } else {
                a.field_downloadURL = str3;
                int obj2 = 1;
            }
            if (obj2 != null) {
                z = c(a);
            }
            String str6 = "MicroMsg.AppBrandWxaPkgStorage";
            String str7 = "flushWxaPkgVersionInfo, update record %b, appId %s, oldVersion %d, newVersion %d, oldURL %s, newURL %s, oldMd5 %s, newMd5 %s";
            Object[] objArr = new Object[8];
            boolean z2 = obj2 != null && z;
            objArr[0] = Boolean.valueOf(z2);
            objArr[1] = str;
            objArr[2] = Integer.valueOf(aj);
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = str4;
            objArr[5] = str3;
            objArr[6] = str5;
            objArr[7] = str2;
            x.i(str6, str7, objArr);
            if (obj2 == null || !z) {
                return false;
            }
            return true;
        }
    }

    public final boolean a(String str, cgw cgw, int i) {
        if (bi.oW(str)) {
            x.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaAppVersionInfo, args invalid appId = %s, vInfo = %s", new Object[]{str, cgw});
            return false;
        }
        return a(str, i, cgw.riv, cgw.sBc, cgw.sBd);
    }

    public final boolean a(String str, d dVar) {
        if (bi.oW(str) || dVar == null) {
            x.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaAppVersionInfoV2, args invalid appId = %s, vInfo = %s", new Object[]{str, dVar});
            return false;
        }
        a(str, 0, dVar.cbu, dVar.fsl);
        return a(str, 0, dVar.cbu, dVar.fsj, null);
    }

    public final boolean g(String str, int i, String str2) {
        return a(str, 0, i, str2, null);
    }

    public final al a(String str, int i, int i2, String... strArr) {
        al alVar = null;
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : al.fhI) {
            stringBuilder.append(append).append("=? and ");
        }
        stringBuilder.append("1=1");
        Cursor a = this.fhY.a("AppBrandWxaPkgManifestRecord", bi.G(strArr) ? null : strArr, stringBuilder.toString(), new String[]{str, String.valueOf(i), String.valueOf(i2)}, null, null, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                alVar = new al();
                alVar.d(a);
                alVar.field_appId = str;
            }
            a.close();
        }
        return alVar;
    }

    private boolean b(al alVar) {
        x.i("MicroMsg.AppBrandWxaPkgStorage", "insertManifest, appId %s, type %d, version %d", new Object[]{alVar.field_appId, Integer.valueOf(alVar.field_debugType), Integer.valueOf(alVar.field_version)});
        return this.fhZ.b(alVar);
    }

    final int ak(String str, int i) {
        if (!a.jC(0)) {
            return 0;
        }
        x.i("MicroMsg.AppBrandWxaPkgStorage", "deletePkgsBelowVersion, appId %s, pkgType %d, pkgVersion %d", new Object[]{str, Integer.valueOf(0), Integer.valueOf(i)});
        return this.fhY.delete("AppBrandWxaPkgManifestRecord", String.format("%s=? and %s=? and %s<?", new Object[]{"appId", "debugType", "version"}), new String[]{str, "0", String.valueOf(i)});
    }

    @SuppressLint({"DefaultLocale"})
    public final boolean d(String str, int i, int i2, String str2) {
        if (bi.oW(str)) {
            return false;
        }
        if (a.ho(i)) {
            i2 = 1;
        }
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("pkgPath", str2);
        if (this.fhY.update("AppBrandWxaPkgManifestRecord", contentValues, String.format("%s=? and %s=? and %s=?", new Object[]{"appId", "debugType", "version"}), new String[]{str, String.valueOf(i), String.valueOf(i2)}) <= 0) {
            return false;
        }
        return true;
    }

    private boolean c(al alVar) {
        x.i("MicroMsg.AppBrandWxaPkgStorage", "updateManifest, appId %s, version %d, pkgType %d", new Object[]{alVar.field_appId, Integer.valueOf(alVar.field_version), Integer.valueOf(alVar.field_debugType)});
        return this.fhZ.c(alVar, al.fhI);
    }

    public final void c(List<String> list, List<Integer> list2) {
        int i = 0;
        if (list.size() > 0 && list2.size() > 0 && list.size() == list2.size()) {
            x.i("MicroMsg.AppBrandWxaPkgStorage", "batchDeleteAppPkg, size %d", new Object[]{Integer.valueOf(list.size())});
            long dO = this.fhY.dO(Thread.currentThread().getId());
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    al((String) list.get(i2), ((Integer) list2.get(i2)).intValue());
                    i = i2 + 1;
                } else {
                    this.fhY.gp(dO);
                    return;
                }
            }
        }
    }

    public final int al(String str, int i) {
        if (bi.oW(str)) {
            return 0;
        }
        x.i("MicroMsg.AppBrandWxaPkgStorage", "deleteAppPkg, appId %s, debugType %d", new Object[]{str, Integer.valueOf(i)});
        String format = String.format("%s=? and %s=?", new Object[]{"appId", "debugType"});
        String[] strArr = new String[]{str, String.valueOf(i)};
        Cursor a = this.fhY.a("AppBrandWxaPkgManifestRecord", new String[]{"pkgPath"}, format, strArr, null, null, null, 2);
        if (a == null) {
            return 0;
        }
        if (a.moveToFirst()) {
            List<String> linkedList = new LinkedList();
            do {
                linkedList.add(a.getString(0));
            } while (a.moveToNext());
            a.close();
            for (String deleteFile : linkedList) {
                com.tencent.mm.a.e.deleteFile(deleteFile);
            }
            int delete = this.fhY.delete("AppBrandWxaPkgManifestRecord", format, strArr);
            u(str, i, -1);
            return delete;
        }
        a.close();
        return 0;
    }

    public final void d(al alVar) {
        this.fhZ.a(alVar);
    }

    public final boolean a(String str, int i, int i2, List<WxaAttributes.e> list) {
        if (bi.oW(str) || bi.cX(list)) {
            return false;
        }
        int i3;
        int i4;
        if (a.jC(i)) {
            i3 = i2;
        } else {
            i3 = 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');
        for (WxaAttributes.e eVar : list) {
            stringBuilder.append(',').append(eVar.name).append("::").append(eVar.bKg);
        }
        stringBuilder.append('}');
        x.i("MicroMsg.AppBrandWxaPkgStorage", "updateModuleList, appId %s, type %d, version %d, list %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i3), stringBuilder.toString()});
        String format = String.format(Locale.US, "where %s like '%s$%%' and %s=%d and %s=%d", new Object[]{"appId", str, "debugType", Integer.valueOf(i), "version", Integer.valueOf(i3)});
        Cursor b = this.fhY.b(String.format(Locale.US, "select count(*) from %s %s", new Object[]{"AppBrandWxaPkgManifestRecord", format}), null, 2);
        if (b == null) {
            i4 = 0;
        } else {
            if (b.moveToFirst()) {
                i4 = b.getInt(0);
            } else {
                i4 = 0;
            }
            b.close();
        }
        if (i4 != 0 && i4 == list.size()) {
            return false;
        }
        this.fhY.fV("AppBrandWxaPkgManifestRecord", String.format(Locale.US, "delete from %s %s", new Object[]{"AppBrandWxaPkgManifestRecord", format}));
        for (WxaAttributes.e eVar2 : list) {
            format = new r(str, eVar2.name).toString();
            if (a.jC(i)) {
                a(format, i, i3, eVar2.bKg, null);
            } else {
                a(format, i, null, eVar2.bKg, 0, 0);
            }
        }
        return true;
    }

    private boolean u(String str, int i, int i2) {
        Locale locale = Locale.US;
        String str2 = "where %s like '%s$%%' and %s=%d and %s";
        Object[] objArr = new Object[5];
        objArr[0] = "appId";
        objArr[1] = str;
        objArr[2] = "debugType";
        objArr[3] = Integer.valueOf(i);
        objArr[4] = i2 > 0 ? "version=" + i2 : "1=1";
        String format = String.format(locale, str2, objArr);
        format = String.format(Locale.US, "delete from %s %s", new Object[]{"AppBrandWxaPkgManifestRecord", format});
        x.i("MicroMsg.AppBrandWxaPkgStorage", "deleteModuleList, appId %s, type %d, version %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        return this.fhY.fV("AppBrandWxaPkgManifestRecord", format);
    }
}
