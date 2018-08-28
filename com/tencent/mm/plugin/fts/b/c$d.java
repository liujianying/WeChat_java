package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.c.c;

class c$d extends a {
    private String gBf;
    final /* synthetic */ c jux;

    public c$d(c cVar, String str) {
        this.jux = cVar;
        this.gBf = str;
    }

    public final boolean execute() {
        c cVar = this.jux.jup;
        String str = this.gBf;
        cVar.jvj.bindLong(1, -1);
        cVar.jvj.bindString(2, str);
        cVar.jvj.bindLong(3, -1);
        cVar.jvj.execute();
        return true;
    }

    public final String afC() {
        return String.format("{conversation: %s}", new Object[]{this.gBf});
    }

    public final String getName() {
        return "DeleteTalkerTask";
    }
}
