package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import java.util.List;

class b$d extends a {
    final /* synthetic */ b jum;
    private String path;

    public b$d(b bVar, String str) {
        this.jum = bVar;
        this.path = str;
    }

    public final String getName() {
        return "UpdateFeatureIndexTask";
    }

    public final boolean execute() {
        List CF = b.CF(this.path);
        this.jum.juk.beginTransaction();
        this.jum.juk.bl(CF);
        this.jum.juk.commit();
        this.jum.juk.k(c.jqe);
        this.jum.dhW.a(131132, new b.a(this.jum, (byte) 0));
        e topHitsLogic = ((PluginFTS) g.n(PluginFTS.class)).getTopHitsLogic();
        topHitsLogic.juO.e(c.jqe, 1);
        return true;
    }
}
