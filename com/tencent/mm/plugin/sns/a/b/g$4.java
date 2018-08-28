package com.tencent.mm.plugin.sns.a.b;

class g$4 implements Runnable {
    final /* synthetic */ long dkM;
    final /* synthetic */ long njd;
    final /* synthetic */ boolean nje;
    final /* synthetic */ g njf;

    g$4(g gVar, long j, long j2, boolean z) {
        this.njf = gVar;
        this.njd = j;
        this.dkM = j2;
        this.nje = z;
    }

    public final void run() {
        if (this.njf.ex(this.njd)) {
            g gVar = this.njf;
            long j = this.njd;
            long j2 = this.dkM;
            boolean z = this.nje;
            h hVar = z ? gVar.niT.containsKey(Long.valueOf(j)) ? (h) gVar.niT.get(Long.valueOf(j)) : new h("timeline") : gVar.niS.containsKey(Long.valueOf(j)) ? (h) gVar.niS.get(Long.valueOf(j)) : new h("timeline");
            if (hVar.njs.nku == 0) {
                hVar.njs.nku = j2;
            }
            if (z) {
                gVar.niT.put(Long.valueOf(j), hVar);
            } else {
                gVar.niS.put(Long.valueOf(j), hVar);
            }
        }
    }
}
