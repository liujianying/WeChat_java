package com.tencent.mm.plugin.wenote.model;

import com.tencent.mm.bg.c;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.fav.a.ae;

public final class a extends p implements b {
    public a() {
        super(c.Un("wenote"));
    }

    public final void parallelsDependency() {
        com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).aN(g.n(ae.class));
        com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).aN(g.n(com.tencent.mm.plugin.record.a.a.class));
    }
}
