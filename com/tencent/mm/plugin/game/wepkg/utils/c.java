package com.tencent.mm.plugin.game.wepkg.utils;

import android.database.Cursor;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.game.wepkg.a.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public final class c {
    public com.tencent.mm.plugin.game.wepkg.model.c kgn = new com.tencent.mm.plugin.game.wepkg.model.c();
    public com.tencent.mm.sdk.b.c kgo = new 1(this);
    public final com.tencent.mm.sdk.b.c kgp = new 2(this);

    static /* synthetic */ boolean a(c cVar, int i) {
        if (!g.AU().AG()) {
            Collection collection;
            x.i("MicroMsg.Wepkg.WepkgListener", "triggerDownload downloadTriggerType:%d", Integer.valueOf(i));
            d aVo = d.aVo();
            if (!aVo.fAQ) {
                collection = null;
            } else if (i == -1) {
                collection = null;
            } else {
                String string;
                collection = new HashSet();
                Cursor rawQuery = aVo.rawQuery(String.format("select distinct %s from %s where %s=?", new Object[]{"pkgId", "WepkgVersion", "downloadTriggerType"}), new String[]{String.valueOf(i)});
                if (rawQuery != null) {
                    if (rawQuery.moveToFirst()) {
                        do {
                            String string2 = rawQuery.getString(0);
                            if (!bi.oW(string2)) {
                                collection.add(string2);
                            }
                        } while (rawQuery.moveToNext());
                    }
                    rawQuery.close();
                }
                Collection hashSet = new HashSet();
                Cursor rawQuery2 = aVo.rawQuery(String.format("select distinct %s from %s where (%s=0 or %s=0) and %s=? and %s<?", new Object[]{"pkgId", "WepkgVersion", "bigPackageReady", "preloadFilesReady", "downloadTriggerType", "packageDownloadCount"}), new String[]{String.valueOf(i), "1"});
                if (rawQuery2 != null) {
                    if (rawQuery2.moveToFirst()) {
                        do {
                            string = rawQuery2.getString(0);
                            if (!bi.oW(string)) {
                                hashSet.add(string);
                            }
                        } while (rawQuery2.moveToNext());
                    }
                    rawQuery2.close();
                }
                Collection hashSet2 = new HashSet();
                Cursor rawQuery3 = aVo.rawQuery(String.format("select distinct %s from %s where %s=0 and %s<?", new Object[]{"pkgId", "WepkgPreloadFiles", "completeDownload", "fileDownloadCount"}), new String[]{"1"});
                if (rawQuery3 != null) {
                    if (rawQuery3.moveToFirst()) {
                        do {
                            string = rawQuery3.getString(0);
                            if (!bi.oW(string)) {
                                hashSet2.add(string);
                            }
                        } while (rawQuery3.moveToNext());
                    }
                    rawQuery3.close();
                }
                hashSet.addAll(hashSet2);
                collection.retainAll(hashSet);
                x.i("MicroMsg.Wepkg.WepkgVersionStorage", "trigger Predownload size:%d, List:%s", Integer.valueOf(collection.size()), collection.toString());
            }
            if (!(collection == null || collection.size() == 0)) {
                d.Em().H(new 3(cVar, new ArrayList(collection)));
                return true;
            }
        }
        return false;
    }
}
