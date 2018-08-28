package com.tencent.mm.plugin.downloader.model;

class b$2 implements Runnable {
    final /* synthetic */ String dat;
    final /* synthetic */ long ibH;
    final /* synthetic */ b ibK;

    b$2(b bVar, long j, String str) {
        this.ibK = bVar;
        this.ibH = j;
        this.dat = str;
    }

    public final void run() {
        for (l h : b.aCQ()) {
            h.h(this.ibH, this.dat);
        }
        if (b.aCR() != null) {
            b.aCR().h(this.ibH, this.dat);
        }
    }
}
