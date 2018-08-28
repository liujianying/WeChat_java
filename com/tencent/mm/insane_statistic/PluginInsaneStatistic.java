package com.tencent.mm.insane_statistic;

import com.tencent.mm.ak.r;
import com.tencent.mm.insane_statistic.a.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;

public class PluginInsaneStatistic extends f implements a {
    public void execute(g gVar) {
        if (gVar.ES()) {
            r.dWN = new b();
            com.tencent.mm.modelstat.r.eld = new a();
        }
    }
}
