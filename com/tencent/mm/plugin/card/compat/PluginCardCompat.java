package com.tencent.mm.plugin.card.compat;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.plugin.card.compat.a.a;
import com.tencent.mm.plugin.card.compat.a.b;

public final class PluginCardCompat extends f implements b {
    public final void installed() {
        super.installed();
        alias(b.class);
    }

    public final void execute(g gVar) {
        if (gVar.ES()) {
            com.tencent.mm.kernel.g.a(a.class, new e(new a()));
        }
    }
}
