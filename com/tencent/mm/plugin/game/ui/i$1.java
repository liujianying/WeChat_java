package com.tencent.mm.plugin.game.ui;

class i$1 implements Runnable {
    final /* synthetic */ i jVV;

    i$1(i iVar) {
        this.jVV = iVar;
    }

    public final void run() {
        this.jVV.notifyDataSetChanged();
    }
}
