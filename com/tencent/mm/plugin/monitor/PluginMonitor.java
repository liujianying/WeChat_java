package com.tencent.mm.plugin.monitor;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.monitor.a.a;
import com.tencent.mm.sdk.platformtools.x;

public class PluginMonitor extends f implements a {
    public void installed() {
        super.installed();
        alias(a.class);
    }

    public void execute(g gVar) {
        if (gVar.ES()) {
            x.i("MicroMsg.PluginMonitor", "PluginMonitor execute PluginMonitor new SubCoreBaseMonitor");
            pin(new p(b.class));
        }
    }

    public String name() {
        return "plugin-monitor";
    }
}
