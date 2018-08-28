package com.tencent.mm.plugin.appbrand.q;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class b {
    private static LinkedList<d> dav = new LinkedList();
    private static HashSet<a> gBl = new HashSet();
    private static boolean gBm = false;
    private static boolean gBn = false;

    public static synchronized void reset() {
        synchronized (b.class) {
            gBm = false;
            gBn = false;
            dav.clear();
            gBl.clear();
        }
    }

    public static synchronized void a(String str, a aVar) {
        synchronized (b.class) {
            if (gBm) {
                gBl.add(aVar);
            } else if (gBn) {
                aVar.w(dav);
            } else {
                gBm = true;
                gBl.add(aVar);
                g.Ek();
                g.Em().H(new 1(str));
            }
        }
    }

    private static synchronized void done() {
        synchronized (b.class) {
            x.i("MicroMsg.AppBrandHistoryListLogic", "done");
            gBn = true;
            gBm = false;
            Iterator it = gBl.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar != null) {
                    aVar.w(dav);
                }
            }
            gBl.clear();
        }
    }

    public static boolean lN(int i) {
        return 33 == i || 36 == i;
    }

    protected static String a(bd bdVar, boolean z, String str) {
        if (bdVar.field_isSend == 1) {
            return q.GF();
        }
        String str2 = null;
        if (z) {
            str2 = com.tencent.mm.model.bd.iB(bdVar.field_content);
        }
        if (bi.oW(str2)) {
            return str;
        }
        return str2;
    }
}
