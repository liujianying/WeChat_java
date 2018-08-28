package com.tencent.mm.plugin.appbrand.ui.recents;

import android.database.Cursor;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.appusage.l;
import com.tencent.mm.plugin.appbrand.appusage.l.a;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.ui.recents.a.d;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

class a$d$2 implements Runnable {
    final /* synthetic */ d gzn;
    final /* synthetic */ k gzo;

    a$d$2(d dVar, k kVar) {
        this.gzn = dVar;
        this.gzo = kVar;
    }

    public final void run() {
        int i;
        if (this.gzo.fmd) {
            e.abh().g(this.gzo.bGy, this.gzo.fig, true);
            e.abg().a(this.gzo.bGy, this.gzo.fig, false, 0, 2, null);
            i = 2;
        } else {
            l abh = e.abh();
            String str = this.gzo.bGy;
            int i2 = this.gzo.fig;
            if (!bi.oW(str)) {
                Object obj = null;
                long VE = bi.VE();
                if (abh.aq(str, i2)) {
                    obj = 1;
                } else {
                    a aVar = new a();
                    aVar.field_username = str;
                    aVar.field_versionType = i2;
                    aVar.field_updateTime = VE;
                    abh.fme.a(aVar, false);
                    if (abh.aq(str, i2)) {
                        abh.b("single", 2, aVar);
                        obj = 1;
                    }
                }
                if (obj != null) {
                    Cursor query = abh.fhY.query("AppBrandStarApp", new String[]{"rowid"}, null, null, null, null, String.format(Locale.US, "%s desc limit %d offset %d", new Object[]{"updateTime", Long.valueOf(Long.MAX_VALUE), Integer.valueOf(abh.fmf)}));
                    if (query != null) {
                        Object obj2;
                        if (query.moveToFirst()) {
                            LinkedList linkedList = new LinkedList();
                            do {
                                linkedList.add(String.valueOf(query.getLong(0)));
                            } while (query.moveToNext());
                            obj2 = linkedList;
                        } else {
                            obj2 = null;
                        }
                        query.close();
                        if (!bi.cX(obj2)) {
                            String[] strArr = new String[1];
                            long dO = abh.fhY.dO(Thread.currentThread().getId());
                            Iterator it = obj2.iterator();
                            while (it.hasNext()) {
                                strArr[0] = (String) it.next();
                                abh.fhY.delete("AppBrandStarApp", "rowid=?", strArr);
                            }
                            abh.fhY.gp(dO);
                            abh.b("batch", 5, obj2);
                        }
                    }
                    s sVar = new s(1003, false, i2, 1, 1, str, 1, null);
                    sVar.fmC = new l$1(abh, str, i2, VE);
                    sVar.KM();
                }
            }
            i = 1;
        }
        com.tencent.mm.plugin.appbrand.report.a.b(this.gzo.appId, this.gzo.fig + 1, i, 1, a.t(this.gzn.gyS));
    }
}
