package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.k.a;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class g extends i<f> implements u {
    public static final String[] dzV = new String[]{i.a(f.fgt, "AppBrandLocalUsageRecord")};
    private final e fgu;

    public g(e eVar) {
        super(eVar, f.fgt, "AppBrandLocalUsageRecord", f.ciG);
        this.fgu = eVar;
    }

    public final List<LocalUsageInfo> jL(int i) {
        return B(i, true);
    }

    public final List<LocalUsageInfo> B(int i, boolean z) {
        List<LocalUsageInfo> list = null;
        Cursor rawQuery = this.fgu.rawQuery("select AppBrandLocalUsageRecord.username,AppBrandLocalUsageRecord.versionType,WxaAttributesTable.nickname,WxaAttributesTable.brandIconURL,WxaAttributesTable.appId from AppBrandLocalUsageRecord left outer join WxaAttributesTable on AppBrandLocalUsageRecord.username=WxaAttributesTable.username order by AppBrandLocalUsageRecord.updateTime desc limit " + Math.max(i, 1) + " offset 0", null);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                Collection linkedList = new LinkedList();
                do {
                    String string = rawQuery.getString(0);
                    if (!bi.oW(string)) {
                        linkedList.add(new LocalUsageInfo(string, rawQuery.getString(4), rawQuery.getInt(1), rawQuery.getString(2), rawQuery.getString(3)));
                    }
                } while (rawQuery.moveToNext());
                rawQuery.close();
                list = new ArrayList(linkedList.size());
                list.addAll(linkedList);
                if (z) {
                    ak(list);
                }
            } else {
                rawQuery.close();
            }
        }
        return list;
    }

    private static void ak(List<LocalUsageInfo> list) {
        c fJ = com.tencent.mm.model.c.c.Jx().fJ("100361");
        if (fJ.isValid() && bi.getInt((String) fJ.ckq().get("isOpenBatchAttrSync"), 0) > 0) {
            Collection hashSet = new HashSet(list.size());
            for (LocalUsageInfo localUsageInfo : list) {
                hashSet.add(localUsageInfo.username);
            }
            List arrayList = new ArrayList(hashSet.size());
            arrayList.addAll(hashSet);
            r.a(arrayList, a.fru);
        }
    }

    public final boolean ap(String str, int i) {
        return b(str, i, a.flt);
    }

    public final boolean a(String str, int i, a aVar) {
        boolean z = false;
        x.i("MicroMsg.AppBrandLocalUsageStorage", "addUsage, username %s, type %d, scene %s", new Object[]{str, Integer.valueOf(i), aVar});
        if (!bi.oW(str)) {
            f fVar = new f();
            fVar.field_username = str;
            fVar.field_versionType = i;
            if (super.b(fVar, f.fgs)) {
                fVar.field_updateTime = bi.VE();
                z = super.a(fVar.sKx, fVar, false);
                if (z) {
                    b("single", 3, null);
                }
            } else {
                fVar.field_updateTime = bi.VE();
                super.a(fVar, false);
                z = super.b(fVar, f.fgs);
                if (z) {
                    this.fgu.fV("AppBrandLocalUsageRecord", "delete from AppBrandLocalUsageRecord where rowid not in ( select rowid from AppBrandLocalUsageRecord order by updateTime desc  limit " + AppBrandGlobalSystemConfig.adZ().fpN + " offset 0)");
                    b("single", 2, null);
                }
            }
        }
        return z;
    }

    final boolean b(String str, int i, a aVar) {
        boolean z = false;
        x.i("MicroMsg.AppBrandLocalUsageStorage", "removeUsage, username %s, type %d, scene %s", new Object[]{str, Integer.valueOf(i), aVar});
        if (!bi.oW(str)) {
            f fVar = new f();
            fVar.field_username = str;
            fVar.field_versionType = i;
            z = a(fVar, false, f.fgs);
            if (z) {
                b("single", 5, null);
            }
            if (z && a.flt == aVar) {
                com.tencent.mm.plugin.appbrand.task.e.aN(q.rW(str), i);
            }
        }
        return z;
    }

    private boolean a(f fVar, boolean z, String... strArr) {
        if (z) {
            return super.a(fVar, z, strArr);
        }
        if (!b(fVar, strArr)) {
            return false;
        }
        super.a(fVar, z, strArr);
        if (b(fVar, strArr)) {
            return false;
        }
        return true;
    }
}
