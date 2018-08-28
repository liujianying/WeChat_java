package com.tencent.mm.plugin.downloader.model;

class b$7 implements Runnable {
    final /* synthetic */ long ibH;
    final /* synthetic */ b ibK;

    b$7(b bVar, long j) {
        this.ibK = bVar;
        this.ibH = j;
    }

    public final void run() {
        for (l bP : b.aCQ()) {
            bP.bP(this.ibH);
        }
    }
}
