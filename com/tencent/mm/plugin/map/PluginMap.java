package com.tencent.mm.plugin.map;

import com.tencent.mm.bg.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.map.a.a;

public class PluginMap extends f implements a {
    public String name() {
        return "plugin-map";
    }

    public void installed() {
        alias(a.class);
    }

    public void configure(g gVar) {
        if (gVar.ES()) {
            pin(new p(l.class));
        }
    }

    public void execute(g gVar) {
        if (gVar.ES()) {
            c.Um("location");
        }
    }
}
