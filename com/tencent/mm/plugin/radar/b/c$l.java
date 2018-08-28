package com.tencent.mm.plugin.radar.b;

final class c$l implements Runnable {
    final /* synthetic */ String mjE;
    final /* synthetic */ long mjF;
    final /* synthetic */ boolean mjJ;
    final /* synthetic */ String mjL;
    final /* synthetic */ c mjy;

    c$l(c cVar, boolean z, String str, String str2, long j) {
        this.mjy = cVar;
        this.mjJ = z;
        this.mjL = str;
        this.mjE = str2;
        this.mjF = j;
    }

    public final void run() {
        this.mjy.mjt.a(this.mjJ, this.mjL, this.mjE, this.mjF);
    }
}
