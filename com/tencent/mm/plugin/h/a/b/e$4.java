package com.tencent.mm.plugin.h.a.b;

class e$4 implements Runnable {
    final /* synthetic */ e hgr;
    final /* synthetic */ long hgw;
    final /* synthetic */ f hgx;

    public e$4(e eVar, long j, f fVar) {
        this.hgr = eVar;
        this.hgw = j;
        this.hgx = fVar;
    }

    public final void run() {
        this.hgr.hfF.put(Long.valueOf(this.hgw), this.hgx);
    }
}
