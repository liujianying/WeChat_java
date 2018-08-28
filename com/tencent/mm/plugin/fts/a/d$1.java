package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.plugin.fts.a.a.l;
import java.util.Comparator;
import java.util.Map;

class d$1 implements Comparator<l> {
    final /* synthetic */ Map jqJ;

    d$1(Map map) {
        this.jqJ = map;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return d.a(this.jqJ, ((l) obj).type, ((l) obj2).type);
    }
}
