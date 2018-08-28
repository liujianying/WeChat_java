package com.tencent.mm.plugin.sns.a.b;

class g$1 implements Runnable {
    final /* synthetic */ long njd;
    final /* synthetic */ boolean nje;
    final /* synthetic */ g njf;

    g$1(g gVar, long j, boolean z) {
        this.njf = gVar;
        this.njd = j;
        this.nje = z;
    }

    public final void run() {
        if (this.njf.ex(this.njd)) {
            g gVar = this.njf;
            long j = this.njd;
            boolean z = this.nje;
            h hVar = z ? gVar.niT.containsKey(Long.valueOf(j)) ? (h) gVar.niT.get(Long.valueOf(j)) : new h("timeline") : gVar.niS.containsKey(Long.valueOf(j)) ? (h) gVar.niS.get(Long.valueOf(j)) : new h("timeline");
            hVar.njk = 1;
            hVar.njs.nkp++;
            if (z) {
                gVar.niT.put(Long.valueOf(j), hVar);
            } else {
                gVar.niS.put(Long.valueOf(j), hVar);
            }
        }
    }
}
