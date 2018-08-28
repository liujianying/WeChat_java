package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.game.a.a.b;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

enum i {
    ;
    
    private static a fAN;
    private static a fAO;

    static {
        fAN = new 1();
        fAO = new 2();
    }

    public static void onCreate() {
        q.aei().a(fAN, c.Em().lnJ.getLooper());
        if (e.abg() != null) {
            e.abg().c(fAO);
        }
    }

    public static void onDestroy() {
        q.aei().d(fAN);
        if (e.abg() != null) {
            e.abg().d(fAO);
        }
    }

    public static void e(a aVar) {
        if (e.abo() != null) {
            e.abo().c(aVar);
        }
    }

    public static void f(a aVar) {
        if (e.abo() != null) {
            e.abo().d(aVar);
        }
    }

    public static List<b> agp() {
        if (e.abo() == null) {
            return null;
        }
        List<k> linkedList = new LinkedList();
        if (e.abg() != null) {
            Collection adf = e.abg().adf();
            if (!bi.cX(adf)) {
                linkedList.addAll(adf);
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            if (!((k) it.next()).aaq()) {
                it.remove();
            }
        }
        if (!bi.cX(linkedList)) {
            List arrayList = new ArrayList();
            for (k a : linkedList) {
                arrayList.add(a(a));
            }
            e.abo().d(arrayList, false);
            x.i("MicroMsg.SearchMiniGameQueryLogic", "AppBrandRecentTaskInfo convert to MiniGameStorage, size:%d", new Object[]{Integer.valueOf(arrayList.size())});
        }
        x.i("MicroMsg.SearchMiniGameQueryLogic", "updateMiniGameList");
        return e.abo().agq();
    }

    public static b sO(String str) {
        if (e.abo() != null) {
            return e.abo().sO(str);
        }
        return null;
    }

    public static k sP(String str) {
        return e.abg() == null ? null : e.abg().rn(str);
    }

    private static com.tencent.mm.plugin.appbrand.game.a.a.a a(k kVar) {
        if (kVar == null) {
            return null;
        }
        com.tencent.mm.plugin.appbrand.game.a.a.a aVar = new com.tencent.mm.plugin.appbrand.game.a.a.a();
        aVar.dfX = kVar.dfX;
        aVar.jQb = kVar.appId;
        aVar.jSv = kVar.appName;
        aVar.jPG = kVar.fmb;
        aVar.hbL = kVar.bGy;
        aVar.fig = kVar.fig;
        return aVar;
    }
}
