package com.tencent.mm.plugin.sns.model;

class b$8 implements Runnable {
    final /* synthetic */ b nmL;
    final /* synthetic */ String nmS;

    b$8(b bVar, String str) {
        this.nmL = bVar;
        this.nmS = str;
    }

    public final void run() {
        b.a(this.nmL, this.nmS);
        this.nmL.LV(this.nmS);
    }
}
