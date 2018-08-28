package com.tencent.mm.plugin.fts.a.c;

import com.tencent.mm.plugin.fts.a.a.l;
import java.util.Comparator;

public final class e implements Comparator<l> {
    public static final e jsX = new e();

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        l lVar = (l) obj;
        l lVar2 = (l) obj2;
        if (lVar2.timestamp < lVar.timestamp) {
            return -1;
        }
        return lVar2.timestamp == lVar.timestamp ? 0 : 1;
    }
}
