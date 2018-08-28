package com.tencent.mm.ui.voicesearch;

class b$4 implements Runnable {
    final /* synthetic */ Runnable bzs;
    final /* synthetic */ b uFM;

    b$4(b bVar, Runnable runnable) {
        this.uFM = bVar;
        this.bzs = runnable;
    }

    public final void run() {
        this.bzs.run();
        this.uFM.notifyDataSetChanged();
    }
}
