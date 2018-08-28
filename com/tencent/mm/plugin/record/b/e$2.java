package com.tencent.mm.plugin.record.b;

import com.tencent.mm.plugin.record.a.c;

class e$2 implements Runnable {
    final /* synthetic */ c msb;
    final /* synthetic */ e msc;

    e$2(e eVar, c cVar) {
        this.msc = eVar;
        this.msb = cVar;
    }

    public final void run() {
        e.a(this.msc).remove(this.msb);
    }
}
