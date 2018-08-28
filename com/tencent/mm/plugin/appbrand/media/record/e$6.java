package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;

class e$6 implements Runnable {
    final /* synthetic */ e giH;
    final /* synthetic */ RecordParam giI;

    public e$6(e eVar, RecordParam recordParam) {
        this.giH = eVar;
        this.giI = recordParam;
    }

    public final void run() {
        synchronized (e.f(this.giH)) {
            e.a(this.giH, this.giI);
            e.g(this.giH);
        }
    }
}
