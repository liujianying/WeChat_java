package com.tencent.mm.plugin.sns.a.b;

class g$2 implements Runnable {
    final /* synthetic */ int fXT;
    final /* synthetic */ long njd;
    final /* synthetic */ boolean nje;
    final /* synthetic */ g njf;
    final /* synthetic */ boolean njg = true;

    g$2(g gVar, long j, int i, boolean z) {
        this.njf = gVar;
        this.njd = j;
        this.fXT = i;
        this.nje = z;
    }

    public final void run() {
        this.njf.a(this.njd, this.fXT, this.njg, this.nje);
    }
}
