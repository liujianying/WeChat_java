package com.tencent.mm.plugin.h.a.a;

class f$8 implements Runnable {
    final /* synthetic */ f hfj;
    final /* synthetic */ int hfm;
    final /* synthetic */ String hfn;
    final /* synthetic */ e hfo;

    f$8(f fVar, int i, String str, e eVar) {
        this.hfj = fVar;
        this.hfm = i;
        this.hfn = str;
        this.hfo = eVar;
    }

    public final void run() {
        f.d(this.hfj).a(this.hfm, this.hfn, this.hfo);
    }
}
