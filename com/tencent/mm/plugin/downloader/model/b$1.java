package com.tencent.mm.plugin.downloader.model;

class b$1 implements Runnable {
    final /* synthetic */ String dat;
    final /* synthetic */ long ibH;
    final /* synthetic */ b ibK;

    b$1(b bVar, long j, String str) {
        this.ibK = bVar;
        this.ibH = j;
        this.dat = str;
    }

    public final void run() {
        for (l onTaskStarted : b.aCQ()) {
            onTaskStarted.onTaskStarted(this.ibH, this.dat);
        }
        if (b.aCR() != null) {
            b.aCR().onTaskStarted(this.ibH, this.dat);
        }
    }
}
