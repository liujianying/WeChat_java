package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;

class c$b extends a {
    final /* synthetic */ c jux;
    private int mCount;

    private c$b(c cVar) {
        this.jux = cVar;
        this.mCount = 0;
    }

    /* synthetic */ c$b(c cVar, byte b) {
        this(cVar);
    }

    public final boolean execute() {
        this.mCount = this.jux.jup.e(c.jqc, -1).size();
        return true;
    }

    public final String afC() {
        return String.format("{mCount: %d}", new Object[]{Integer.valueOf(this.mCount)});
    }

    public final String getName() {
        return "DeleteAllTask";
    }
}
