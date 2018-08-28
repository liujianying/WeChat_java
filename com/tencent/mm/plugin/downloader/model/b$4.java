package com.tencent.mm.plugin.downloader.model;

class b$4 implements Runnable {
    final /* synthetic */ String dat;
    final /* synthetic */ long ibH;
    final /* synthetic */ b ibK;
    final /* synthetic */ boolean ibL;

    b$4(b bVar, long j, String str, boolean z) {
        this.ibK = bVar;
        this.ibH = j;
        this.dat = str;
        this.ibL = z;
    }

    public final void run() {
        for (l b : b.aCQ()) {
            b.b(this.ibH, this.dat, this.ibL);
        }
        if (b.aCR() != null) {
            b.aCR().b(this.ibH, this.dat, this.ibL);
        }
    }
}
