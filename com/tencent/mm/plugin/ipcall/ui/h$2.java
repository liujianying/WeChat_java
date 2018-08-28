package com.tencent.mm.plugin.ipcall.ui;

class h$2 implements Runnable {
    final /* synthetic */ h kxi;

    h$2(h hVar) {
        this.kxi = hVar;
    }

    public final void run() {
        this.kxi.notifyDataSetChanged();
    }
}
