package com.tencent.mm.plugin.fts.a.c;

import com.tencent.mm.plugin.fts.a.a.l;
import java.util.Comparator;

public final class c implements Comparator<l> {
    public static final c jsV = new c();

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        l lVar = (l) obj;
        l lVar2 = (l) obj2;
        int i = lVar.jru - lVar2.jru;
        if (i != 0) {
            return i;
        }
        i = lVar.jsD - lVar2.jsD;
        return i == 0 ? lVar.jsE.compareTo(lVar2.jsE) : i;
    }
}
