package com.tencent.mm.plugin.downloader.model;

class b$3 implements Runnable {
    final /* synthetic */ long ibH;
    final /* synthetic */ b ibK;

    b$3(b bVar, long j) {
        this.ibK = bVar;
        this.ibH = j;
    }

    public final void run() {
        for (l onTaskRemoved : b.aCQ()) {
            onTaskRemoved.onTaskRemoved(this.ibH);
        }
        if (b.aCR() != null) {
            b.aCR().onTaskRemoved(this.ibH);
        }
    }
}
