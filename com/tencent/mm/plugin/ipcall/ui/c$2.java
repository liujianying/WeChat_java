package com.tencent.mm.plugin.ipcall.ui;

class c$2 implements Runnable {
    final /* synthetic */ c ktD;

    c$2(c cVar) {
        this.ktD = cVar;
    }

    public final void run() {
        this.ktD.notifyDataSetChanged();
    }
}
