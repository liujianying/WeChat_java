package com.tencent.mm.plugin.game.ui;

class j$1 implements Runnable {
    final /* synthetic */ j jXK;

    j$1(j jVar) {
        this.jXK = jVar;
    }

    public final void run() {
        this.jXK.invalidateSelf();
    }
}
