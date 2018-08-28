package com.tencent.mm.ac;

import com.tencent.mm.kernel.a.b.a;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.p;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class l implements o, b, com.tencent.mm.kernel.api.bucket.b, c {
    private o dMt;
    private p dMu;

    public final o FU() {
        return this.dMt;
    }

    public final p FV() {
        return this.dMu;
    }

    public final String Gl() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Ek();
        return stringBuilder.append(g.Ei().dqp).append("brandicon/").toString();
    }

    public final List<String> collectStoragePaths() {
        Object linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"brandicon/"});
        return linkedList;
    }

    public final void onAccountInitialized(e.c cVar) {
        f bcY = ((i) g.l(i.class)).bcY();
        o oVar = new o(bcY);
        this.dMt = oVar;
        bcY.a(oVar);
        this.dMu = new p(((i) g.l(i.class)).FW());
    }

    public final void onAccountRelease() {
    }

    public final void parallelsDependency() {
        a.a(this, c.class).aN(g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class));
    }
}
