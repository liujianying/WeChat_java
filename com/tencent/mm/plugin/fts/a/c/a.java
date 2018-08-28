package com.tencent.mm.plugin.fts.a.c;

import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import java.util.Comparator;

public final class a implements Comparator<l> {
    public static final a jsT = new a();

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        l lVar = (l) obj;
        l lVar2 = (l) obj2;
        int i = lVar2.jrT - lVar.jrT;
        if (i != 0) {
            return i;
        }
        if (lVar2.jrT >= 50 && lVar.jrT >= 50) {
            i = d.c(c.jqv, lVar.jru, lVar2.jru);
            if (i != 0) {
                return i;
            }
        }
        i = lVar2.jsM - lVar.jsM;
        if (i != 0) {
            return i;
        }
        if (lVar2.timestamp > lVar.timestamp) {
            return 1;
        }
        return lVar2.timestamp < lVar.timestamp ? -1 : 0;
    }
}
