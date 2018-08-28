package com.tencent.mm.plugin.appbrand.f;

import com.tencent.mm.modelappbrand.a;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

enum i {
    ;
    
    private static final a fyR = null;

    static {
        fyR = new a();
    }

    static void onCreate() {
        q.aei().a(fyR, c.Em().lnJ.getLooper());
    }

    static void onDestroy() {
        q.aei().d(fyR);
    }

    static List<k> afG() {
        List<k> linkedList = new LinkedList();
        if (e.abg() != null) {
            Collection adf = e.abg().adf();
            if (!bi.cX(adf)) {
                linkedList.addAll(adf);
            }
        }
        if (a.JJ()) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                if (((k) it.next()).aaq()) {
                    it.remove();
                }
            }
        }
        return linkedList;
    }

    static k sK(String str) {
        if (e.abg() == null) {
            return null;
        }
        k rn = e.abg().rn(str);
        if (rn == null) {
            return null;
        }
        if (rn.aaq() && a.JJ()) {
            return null;
        }
        return rn;
    }

    static void e(j.a aVar) {
        if (e.abg() != null) {
            e.abg().c(aVar);
        }
    }

    static void f(j.a aVar) {
        if (e.abg() != null) {
            e.abg().d(aVar);
        }
    }
}
