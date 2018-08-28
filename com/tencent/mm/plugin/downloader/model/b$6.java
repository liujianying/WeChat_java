package com.tencent.mm.plugin.downloader.model;

class b$6 implements Runnable {
    final /* synthetic */ long ibH;
    final /* synthetic */ b ibK;

    b$6(b bVar, long j) {
        this.ibK = bVar;
        this.ibH = j;
    }

    public final void run() {
        for (l onTaskPaused : b.aCQ()) {
            onTaskPaused.onTaskPaused(this.ibH);
        }
        if (b.aCR() != null) {
            b.aCR().onTaskPaused(this.ibH);
        }
    }
}
