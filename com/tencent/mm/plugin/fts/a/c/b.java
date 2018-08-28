package com.tencent.mm.plugin.fts.a.c;

import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Comparator;

public final class b implements Comparator<l> {
    public static final b jsU = new b();

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        l lVar = (l) obj;
        l lVar2 = (l) obj2;
        int i = lVar2.jrT - lVar.jrT;
        if (i != 0) {
            return i;
        }
        i = d.a(c.jqq, lVar.type, lVar2.type);
        if (i != 0) {
            return i;
        }
        i = d.c(c.jqv, lVar.jru, lVar2.jru);
        if (i != 0) {
            return i;
        }
        i = lVar.jsD - lVar2.jsD;
        if (i != 0) {
            return i;
        }
        if (lVar.jru != 11 && lVar.jru != 17 && lVar.jru != 18) {
            return bi.aG(lVar.jsE, "").compareToIgnoreCase(lVar2.jsE);
        }
        if (bi.oW(lVar.jsL)) {
            lVar.jsL = d.Ct(lVar.jrv);
            lVar.jsL = lVar.jsL.toLowerCase();
            if (!g.j(lVar.jsL.charAt(0))) {
                lVar.jsL = "~" + lVar.jsL;
            }
        }
        if (bi.oW(lVar2.jsL)) {
            lVar2.jsL = d.Ct(lVar2.jrv);
            lVar2.jsL = lVar2.jsL.toLowerCase();
            if (!g.j(lVar2.jsL.charAt(0))) {
                lVar2.jsL = "~" + lVar2.jsL;
            }
        }
        return lVar.jsL.compareToIgnoreCase(lVar2.jsL);
    }
}
