package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.g.a;
import java.util.LinkedList;
import java.util.Map.Entry;

class g$1 implements Runnable {
    final /* synthetic */ g hsc;

    g$1(g gVar) {
        this.hsc = gVar;
    }

    public final void run() {
        LinkedList linkedList = new LinkedList();
        for (Entry value : this.hsc.hsb.entrySet()) {
            linkedList.add((a) value.getValue());
        }
        g.Eh().dpP.a(new com.tencent.mm.plugin.brandservice.b.g(linkedList, this.hsc.hrZ, this.hsc.hsa), 0);
    }
}
