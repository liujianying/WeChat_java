package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.ac.a;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c {
    LinkedList<String> jKZ = new LinkedList();
    LinkedList<f> jLa = new LinkedList();

    public final void init(Context context) {
        if (this.jLa == null) {
            this.jLa = new LinkedList();
        } else {
            this.jLa.clear();
        }
        if (this.jKZ == null) {
            this.jKZ = new LinkedList();
        } else {
            this.jKZ.clear();
        }
        long currentTimeMillis = System.currentTimeMillis();
        dq(context);
        long currentTimeMillis2 = System.currentTimeMillis();
        aTw();
        long currentTimeMillis3 = System.currentTimeMillis();
        x.i("MicroMsg.GameAppCacheService", "Init time: %d, %d, %d", new Object[]{Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis3 - currentTimeMillis)});
    }

    private void dq(Context context) {
        Cursor cbP = a.bmf().cbP();
        if (cbP == null) {
            x.e("MicroMsg.GameAppCacheService", "getInstalledGame faild: curosr is null");
            return;
        }
        if (cbP.moveToFirst()) {
            do {
                f fVar = new f();
                fVar.d(cbP);
                if (g.a(context, fVar) && !this.jKZ.contains(fVar.field_appId)) {
                    x.i("MicroMsg.GameAppCacheService", "installed game:[%s][%s]", new Object[]{fVar.field_appName, fVar.field_appId});
                    this.jLa.add(fVar);
                    this.jKZ.add(fVar.field_appId);
                }
            } while (cbP.moveToNext());
        }
        cbP.close();
    }

    private void aTw() {
        List arrayList = new ArrayList();
        Cursor rawQuery = ((com.tencent.mm.plugin.downloader.a.c) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.downloader.a.c.class)).FX().rawQuery("select * from FileDownloadInfo where status=3", new String[0]);
        List list;
        if (rawQuery == null) {
            list = arrayList;
        } else {
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.downloader.c.a aVar = new com.tencent.mm.plugin.downloader.c.a();
                aVar.d(rawQuery);
                if (!bi.oW(aVar.field_appId) && aVar.field_appId.startsWith("wx") && aVar.field_status == 3 && e.cn(aVar.field_filePath) && !arrayList.contains(aVar.field_appId)) {
                    arrayList.add(aVar.field_appId);
                }
            }
            rawQuery.close();
            list = arrayList;
        }
        if (!list.isEmpty()) {
            for (String str : list) {
                if (!(bi.oW(str) || this.jKZ.contains(str))) {
                    f bl = g.bl(str, false);
                    if (!(bl == null || this.jLa.contains(bl))) {
                        this.jLa.add(bl);
                        this.jKZ.add(str);
                    }
                }
            }
        }
    }

    public final void clearCache() {
        x.i("MicroMsg.GameAppCacheService", "clear cached apppinfos");
        if (this.jLa != null) {
            this.jLa.clear();
        }
        if (this.jKZ != null) {
            this.jKZ.clear();
        }
    }
}
