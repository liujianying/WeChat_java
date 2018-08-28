package com.tencent.mm.plugin.record.b;

import com.tencent.mm.plugin.record.a.c;

class e$1 implements Runnable {
    final /* synthetic */ c msb;
    final /* synthetic */ e msc;

    e$1(e eVar, c cVar) {
        this.msc = eVar;
        this.msb = cVar;
    }

    public final void run() {
        if (!e.a(this.msc).contains(this.msb)) {
            e.a(this.msc).add(this.msb);
        }
    }
}
