package com.tencent.mm.plugin.radar.b;

final class c$h implements Runnable {
    final /* synthetic */ String mjE;
    final /* synthetic */ long mjF;
    final /* synthetic */ boolean mjJ;
    final /* synthetic */ boolean mjK;
    final /* synthetic */ String mjL;
    final /* synthetic */ c mjy;

    c$h(c cVar, boolean z, boolean z2, String str, String str2, long j) {
        this.mjy = cVar;
        this.mjJ = z;
        this.mjK = z2;
        this.mjL = str;
        this.mjE = str2;
        this.mjF = j;
    }

    public final void run() {
        this.mjy.mjt.a(this.mjJ, this.mjK, this.mjL, this.mjE, this.mjF);
    }
}
