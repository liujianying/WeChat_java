package com.tencent.mm.plugin.kitchen;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.kitchen.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.o;

public class PluginKitchen extends f implements a {
    public void installed() {
        alias(a.class);
    }

    public void dependency() {
        dependsOn(o.class);
    }

    public void execute(g gVar) {
        com.tencent.mm.kernel.g.a(a.class, new com.tencent.mm.plugin.kitchen.b.a());
    }

    public String toString() {
        return "plugin-kitchen";
    }
}
