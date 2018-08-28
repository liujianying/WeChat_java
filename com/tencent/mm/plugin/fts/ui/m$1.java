package com.tencent.mm.plugin.fts.ui;

import com.tencent.mm.plugin.fts.a.n;
import java.util.Comparator;

class m$1 implements Comparator<String> {
    final /* synthetic */ n jxu;

    m$1(n nVar) {
        this.jxu = nVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return this.jxu.stringCompareUtfBinary((String) obj, (String) obj2);
    }
}
