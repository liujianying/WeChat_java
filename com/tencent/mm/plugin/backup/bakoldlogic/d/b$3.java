package com.tencent.mm.plugin.backup.bakoldlogic.d;

class b$3 implements Runnable {
    final /* synthetic */ b hbe;
    final /* synthetic */ Runnable hbi;
    final /* synthetic */ int hbj;

    b$3(b bVar, Runnable runnable, int i) {
        this.hbe = bVar;
        this.hbi = runnable;
        this.hbj = i;
    }

    public final void run() {
        this.hbe.a(this.hbi, this.hbj - 1);
    }
}
