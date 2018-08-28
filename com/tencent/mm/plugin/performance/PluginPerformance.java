package com.tencent.mm.plugin.performance;

import com.tencent.mm.bv.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.performance.a.1;
import com.tencent.mm.plugin.performance.a.a;
import com.tencent.mm.plugin.report.PluginReport;

public class PluginPerformance extends f implements a {
    public void installed() {
        alias(a.class);
    }

    public void dependency() {
        dependsOn(PluginReport.class);
        dependsOn(o.class);
    }

    public void configure(g gVar) {
        c.tfx = new 1();
    }

    public void execute(g gVar) {
    }

    public String toString() {
        return "plugin-performance";
    }
}
