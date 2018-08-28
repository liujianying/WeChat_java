package com.tencent.mm.plugin.fts.a.c;

import com.tencent.mm.plugin.fts.a.a.l;
import java.util.Comparator;

public final class d implements Comparator<l> {
    public static final d jsW = new d();

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        l lVar = (l) obj;
        l lVar2 = (l) obj2;
        if (lVar.timestamp > lVar2.timestamp) {
            return -1;
        }
        if (lVar.timestamp < lVar2.timestamp) {
            return 1;
        }
        if (lVar.jru < lVar2.jru) {
            return 1;
        }
        return lVar.jru <= lVar2.jru ? 0 : -1;
    }
}
