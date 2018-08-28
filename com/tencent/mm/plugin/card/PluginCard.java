package com.tencent.mm.plugin.card;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.c.b;
import com.tencent.mm.plugin.card.model.am;

public class PluginCard extends f implements a {
    public void installed() {
        super.installed();
        alias(a.class);
    }

    public am getCore() {
        return (am) p.v(am.class);
    }

    public void execute(g gVar) {
        if (gVar.ES()) {
            com.tencent.mm.kernel.g.a(a.class, new e(new a()));
            com.tencent.mm.kernel.g.a(b.class, new e(new com.tencent.mm.plugin.card.c.a()));
        }
    }

    public void dependency() {
        dependsOn(com.tencent.mm.plugin.comm.a.a.class);
        dependsOn(com.tencent.mm.plugin.card.compat.a.b.class);
    }

    public String name() {
        return "plugin-card";
    }
}
