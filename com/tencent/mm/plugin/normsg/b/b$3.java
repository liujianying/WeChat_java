package com.tencent.mm.plugin.normsg.b;

class b$3 implements Runnable {
    final /* synthetic */ boolean[] lGA;
    final /* synthetic */ b lGB;
    final /* synthetic */ Throwable lGC;

    b$3(b bVar, Throwable th, boolean[] zArr) {
        this.lGB = bVar;
        this.lGC = th;
        this.lGA = zArr;
    }

    public final void run() {
        b.b(this.lGB, this.lGC);
        synchronized (this.lGA) {
            this.lGA[0] = true;
            this.lGA.notifyAll();
        }
    }
}
