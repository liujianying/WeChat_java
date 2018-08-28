package com.tencent.mm.plugin.bbom;

import com.tencent.mm.bg.c;
import com.tencent.mm.kernel.a.b.a;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.fts.a.n;

public final class f extends p implements b {
    public f() {
        super(c.Un("search"));
    }

    public final void parallelsDependency() {
        a.a(this, com.tencent.mm.kernel.api.c.class).aN(g.n(n.class));
    }
}
