package com.tencent.mm.plugin.game.wepkg.a;

import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.wepkg.model.WepkgVersion;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public class d extends i<c> {
    public static final String[] diD = new String[]{i.a(c.dzU, "WepkgVersion")};
    private static volatile d kdU = null;
    private final h dCZ;
    public final boolean fAQ;

    public static d aVo() {
        if (!g.Eg().Dx()) {
            return new d(null);
        }
        if (kdU == null) {
            synchronized (d.class) {
                if (kdU == null || !kdU.fAQ) {
                    kdU = new d(g.Ei().dqq);
                }
            }
        }
        return kdU;
    }

    private d(h hVar) {
        super(hVar, c.dzU, "WepkgVersion", c.ciG);
        this.dCZ = hVar;
        this.fAQ = hVar != null;
        if (!this.fAQ) {
            x.e("MicroMsg.Wepkg.WepkgVersionStorage", "storage can not work!!!");
        }
    }

    public final c DV(String str) {
        if (!this.fAQ || bi.oW(str)) {
            return null;
        }
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", new Object[]{"WepkgVersion", "pkgId"}), new String[]{str});
        if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.d(rawQuery);
            rawQuery.close();
            x.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgid exist record in DB, pkgid:%s, version:%s", new Object[]{cVar.field_pkgId, cVar.field_version});
            return cVar;
        }
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgid pkgid:%s, no record in DB", new Object[]{str});
        rawQuery.close();
        return null;
    }

    public final c DW(String str) {
        if (!this.fAQ || bi.oW(str)) {
            return null;
        }
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=? and %s=0", new Object[]{"WepkgVersion", "pkgId", "disable"}), new String[]{str});
        if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.d(rawQuery);
            rawQuery.close();
            x.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgidWithAble exist record in DB, pkgid:%s, version:%s, disableWvCache:%s, clearPkgTime:%s, checkIntervalTime:%s, domain:%s, bigPackageReady:%s, preloadFilesReady:%s, preloadFilesAtomic:%s, disable:%s", new Object[]{cVar.field_pkgId, cVar.field_version, Boolean.valueOf(cVar.field_disableWvCache), Long.valueOf(cVar.field_clearPkgTime), Long.valueOf(cVar.field_checkIntervalTime), cVar.field_domain, Boolean.valueOf(cVar.field_bigPackageReady), Boolean.valueOf(cVar.field_preloadFilesReady), Boolean.valueOf(cVar.field_preloadFilesAtomic), Boolean.valueOf(cVar.field_disable)});
            cVar.field_accessTime = com.tencent.mm.plugin.game.wepkg.utils.d.aow();
            super.c(cVar, new String[0]);
            return cVar;
        }
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgidWithAble pkgid:%s, no record in DB", new Object[]{str});
        rawQuery.close();
        return null;
    }

    public final List<WepkgVersion> aVp() {
        List<WepkgVersion> list = null;
        if (this.fAQ) {
            Cursor rawQuery = rawQuery(String.format("select * from %s where %s < ? - %s", new Object[]{"WepkgVersion", "accessTime", "clearPkgTime"}), new String[]{String.valueOf(com.tencent.mm.plugin.game.wepkg.utils.d.aow())});
            x.i("MicroMsg.Wepkg.WepkgVersionStorage", "getNeedCleanRecords queryStr:%s", new Object[]{r1});
            if (rawQuery == null) {
                x.i("MicroMsg.Wepkg.WepkgVersionStorage", "cursor is null");
            } else if (rawQuery.moveToFirst()) {
                list = new ArrayList();
                do {
                    WepkgVersion wepkgVersion = new WepkgVersion();
                    c cVar = new c();
                    cVar.d(rawQuery);
                    wepkgVersion.a(cVar);
                    list.add(wepkgVersion);
                } while (rawQuery.moveToNext());
                rawQuery.close();
                x.i("MicroMsg.Wepkg.WepkgVersionStorage", "record list size:%s", new Object[]{Integer.valueOf(list.size())});
            } else {
                rawQuery.close();
                x.i("MicroMsg.Wepkg.WepkgVersionStorage", "no record");
            }
        }
        return list;
    }

    public final boolean DU(String str) {
        if (!this.fAQ || bi.oW(str)) {
            return false;
        }
        c cVar = new c();
        cVar.field_pkgId = str;
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "deleteRecordByPkgid pkgid:%s, ret:%s", new Object[]{str, Boolean.valueOf(super.a(cVar, new String[0]))});
        return super.a(cVar, new String[0]);
    }

    public final boolean DX(String str) {
        if (!this.fAQ) {
            return false;
        }
        c DV = DV(str);
        if (DV == null) {
            return false;
        }
        DV.field_nextCheckTime = com.tencent.mm.plugin.game.wepkg.utils.d.aow() + DV.field_checkIntervalTime;
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateCheckTime pkgid:%s, ret:%s", new Object[]{str, Boolean.valueOf(super.c(DV, new String[0]))});
        return super.c(DV, new String[0]);
    }

    public final boolean a(String str, boolean z, long j, long j2) {
        if (!this.fAQ) {
            return false;
        }
        c DV = DV(str);
        if (DV == null) {
            return false;
        }
        DV.field_disableWvCache = z;
        DV.field_clearPkgTime = j;
        DV.field_nextCheckTime = (DV.field_nextCheckTime - DV.field_checkIntervalTime) + j2;
        DV.field_checkIntervalTime = j2;
        DV.field_disable = false;
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateConfigInfo pkgid:%s, disableWvCache:%s, clearPkgTime:%s, checkIntervalTime:%s, ret:%s", new Object[]{str, Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(super.c(DV, new String[0]))});
        return super.c(DV, new String[0]);
    }

    public final boolean k(String str, String str2, boolean z) {
        if (!this.fAQ || bi.oW(str)) {
            return false;
        }
        c DV = DV(str);
        if (DV == null) {
            return false;
        }
        DV.field_bigPackageReady = z;
        DV.field_pkgPath = str2;
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateBigPackageReady pkgid:%s, pkgPath:%s, bigPackageReady:%b, ret:%s", new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(super.c(DV, new String[0]))});
        return super.c(DV, new String[0]);
    }

    public final boolean aA(String str, boolean z) {
        if (!this.fAQ || bi.oW(str)) {
            return false;
        }
        c DV = DV(str);
        if (DV == null) {
            return false;
        }
        DV.field_preloadFilesReady = z;
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "updatePreloadFilesReady pkgid:%s, preloadFilesReady:%b, ret:%s", new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(super.c(DV, new String[0]))});
        return super.c(DV, new String[0]);
    }

    public final boolean DY(String str) {
        if (!this.fAQ || bi.oW(str)) {
            return false;
        }
        boolean fV = fV("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[]{"WepkgVersion", "autoDownloadCount", "autoDownloadCount", "pkgId", str}));
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addAutoDownloadCount ret:%s", new Object[]{Boolean.valueOf(fV)});
        return true;
    }

    public final boolean DZ(String str) {
        if (!this.fAQ || bi.oW(str)) {
            return false;
        }
        c DV = DV(str);
        if (DV == null) {
            return true;
        }
        DV.field_disable = true;
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "setWepkgDisable pkgid:%s, ret:%s", new Object[]{str, Boolean.valueOf(super.c(DV, new String[0]))});
        return super.c(DV, new String[0]);
    }

    public final boolean Ea(String str) {
        if (!this.fAQ || bi.oW(str)) {
            return false;
        }
        c DV = DV(str);
        if (DV == null) {
            return false;
        }
        DV.field_createTime = 0;
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateCreateTimeToZero pkgid:%s, ret:%s", new Object[]{str, Boolean.valueOf(super.c(DV, new String[0]))});
        return super.c(DV, new String[0]);
    }
}
