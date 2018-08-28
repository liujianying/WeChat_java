package com.tencent.mm.plugin.downloader.model;

class b$5 implements Runnable {
    final /* synthetic */ int bFr;
    final /* synthetic */ long ibH;
    final /* synthetic */ b ibK;
    final /* synthetic */ boolean ibL;

    b$5(b bVar, long j, int i, boolean z) {
        this.ibK = bVar;
        this.ibH = j;
        this.bFr = i;
        this.ibL = z;
    }

    public final void run() {
        for (l b : b.aCQ()) {
            b.b(this.ibH, this.bFr, this.ibL);
        }
        if (b.aCR() != null) {
            b.aCR().b(this.ibH, this.bFr, this.ibL);
        }
    }
}
