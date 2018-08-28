package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.plugin.fts.a.a.g.a;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.sdk.platformtools.bi;

class c$6 implements a {
    final /* synthetic */ c jux;

    c$6(c cVar) {
        this.jux = cVar;
    }

    public final String[] split(String str) {
        return bi.cW(c.CG(str));
    }

    public final String[] CB(String str) {
        return c.a.jqE.split(str, 2);
    }
}
