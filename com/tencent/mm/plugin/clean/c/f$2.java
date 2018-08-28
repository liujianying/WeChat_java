package com.tencent.mm.plugin.clean.c;

class f$2 implements Runnable {
    final /* synthetic */ f hRm;
    final /* synthetic */ long hRn;

    f$2(f fVar, long j) {
        this.hRm = fVar;
        this.hRn = j;
    }

    public final void run() {
        if (f.a(this.hRm) != null) {
            f.a(this.hRm).ck(this.hRn);
        }
    }
}
