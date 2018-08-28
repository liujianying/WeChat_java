package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;

class f$d extends a {
    final /* synthetic */ f juX;

    private f$d(f fVar) {
        this.juX = fVar;
    }

    /* synthetic */ f$d(f fVar, byte b) {
        this(fVar);
    }

    public final boolean execute() {
        g.Ei().dqq.fV(null, "UPDATE rconversation SET unReadCount = 0;");
        return true;
    }

    public final String getName() {
        return "FTSClearUnReadCountTask";
    }
}
