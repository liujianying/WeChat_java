package com.tencent.mm.plugin.sns.a.b;

class g$3 implements Runnable {
    final /* synthetic */ long njd;
    final /* synthetic */ g njf;
    final /* synthetic */ long njh;

    g$3(g gVar, long j, long j2) {
        this.njf = gVar;
        this.njd = j;
        this.njh = j2;
    }

    public final void run() {
        if (this.njf.ex(this.njd)) {
            g gVar = this.njf;
            long j = this.njh;
            if (!gVar.niR.contains(Long.valueOf(j))) {
                gVar.niR.add(Long.valueOf(j));
            }
        }
    }
}
