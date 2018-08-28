package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n;

public final class o implements c, com.tencent.mm.kernel.b.c {
    public static final o qDq = new o();
    private final n qDr = new 1(this);
    private final com.tencent.mm.sdk.b.c qDs = new 2(this);

    public final void onAccountInitialized(e.c cVar) {
        for (g bUO : r.ccI()) {
            bUO.bUO();
        }
        g.Eh().a(this.qDr);
        this.qDs.cht();
    }

    public final void onAccountRelease() {
        g.Eh().b(this.qDr);
        this.qDs.dead();
        for (g onAccountRelease : r.ccI()) {
            onAccountRelease.onAccountRelease();
        }
    }
}
