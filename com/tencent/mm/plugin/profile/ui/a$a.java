package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.plugin.fts.a.a.l;
import java.util.Comparator;

class a$a implements Comparator<l> {
    final /* synthetic */ a lUz;

    private a$a(a aVar) {
        this.lUz = aVar;
    }

    /* synthetic */ a$a(a aVar, byte b) {
        this(aVar);
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        l lVar = (l) obj;
        l lVar2 = (l) obj2;
        if (lVar2.timestamp > lVar.timestamp) {
            return 1;
        }
        return lVar2.timestamp < lVar.timestamp ? -1 : 0;
    }
}
