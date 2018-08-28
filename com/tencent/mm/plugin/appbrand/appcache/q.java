package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.StatFs;
import android.util.Pair;
import com.tencent.mm.g.b.a.l;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.ap.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class q {
    private static final byte[] fgk = new byte[0];

    public static void ae(String str, int i) {
        if (!bi.oW(str)) {
            String rW = com.tencent.mm.plugin.appbrand.config.q.rW(str);
            if (!bi.oW(rW)) {
                w wVar = (w) e.x(w.class);
                if (wVar != null) {
                    synchronized (fgk) {
                        v vVar = new v();
                        vVar.field_appId = rW;
                        vVar.field_type = i;
                        if (wVar.b(vVar, v.fgs)) {
                            vVar.field_hit++;
                            vVar.field_hitTimeMS = bi.VF();
                            wVar.c(vVar, v.fgs);
                        } else {
                            vVar.field_hit = 1;
                            vVar.field_hitTimeMS = bi.VF();
                            wVar.b(vVar);
                        }
                    }
                }
            }
        }
    }

    public static a bL(long j) {
        if (j <= 0) {
            return a.fgl;
        }
        StatFs statFs = new StatFs(ah.abY());
        long blockSize = (long) (statFs.getBlockSize() * statFs.getAvailableBlocks());
        if (blockSize < 0 || blockSize > j) {
            return a.fgl;
        }
        w wVar = (w) e.x(w.class);
        if (wVar == null) {
            x.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, lruStorage NULL", new Object[]{Long.valueOf(j)});
            return a.fgn;
        }
        String format = String.format(Locale.US, " %s, %s ASC", new Object[]{"hit", "hitTimeMS"});
        LinkedList linkedList = new LinkedList();
        synchronized (fgk) {
            Cursor a = wVar.diF.a("PkgUsageLRURecord", new String[]{"appId", "type"}, null, null, null, null, format, 2);
            a aVar;
            if (a == null) {
                aVar = a.fgn;
                return aVar;
            } else if (a.moveToFirst()) {
                while (true) {
                    try {
                        linkedList.add(Pair.create(a.getString(0), Integer.valueOf(a.getInt(1))));
                        if (!a.moveToNext()) {
                            break;
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy, read from cursor e = %s", new Object[]{e});
                        ap abi = e.abi();
                        if (abi == null) {
                            x.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, pkgStorage NULL", new Object[]{Long.valueOf(j)});
                            return a.fgn;
                        }
                        long j2 = 0;
                        int i = 0;
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            Pair pair = (Pair) it.next();
                            int i2 = i;
                            for (al alVar : abi.a((String) pair.first, ((Integer) pair.second).intValue(), a.fib, new String[]{"pkgPath"})) {
                                j2 += (long) com.tencent.mm.a.e.cm(alVar.field_pkgPath);
                                com.tencent.mm.a.e.deleteFile(alVar.field_pkgPath);
                                int i3 = i2 + 1;
                                if (j2 >= j) {
                                    l lVar = new l();
                                    lVar.ciw = 3;
                                    lVar.ciz = (long) i3;
                                    lVar.ciu = k.abH() ? 1 : 0;
                                    lVar.RD();
                                    return a.fgm;
                                }
                                i2 = i3;
                            }
                            i = i2;
                        }
                        return a.fgn;
                    } finally {
                        a.close();
                    }
                }
            } else {
                a.close();
                aVar = a.fgn;
                return aVar;
            }
        }
    }
}
