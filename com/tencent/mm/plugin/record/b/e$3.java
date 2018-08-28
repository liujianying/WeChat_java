package com.tencent.mm.plugin.record.b;

import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.plugin.record.a.f;
import java.util.Iterator;

class e$3 implements Runnable {
    final /* synthetic */ int bpX;
    final /* synthetic */ e msc;
    final /* synthetic */ f msd;

    e$3(e eVar, int i, f fVar) {
        this.msc = eVar;
        this.bpX = i;
        this.msd = fVar;
    }

    public final void run() {
        Iterator it = e.a(this.msc).iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(this.bpX, this.msd);
        }
    }
}
