package com.tencent.mm.plugin.brandservice.ui.base;

class b$1 implements Runnable {
    final /* synthetic */ b hqh;

    b$1(b bVar) {
        this.hqh = bVar;
    }

    public final void run() {
        this.hqh.invalidateSelf();
    }
}
