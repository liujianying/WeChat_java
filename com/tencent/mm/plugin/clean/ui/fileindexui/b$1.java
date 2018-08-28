package com.tencent.mm.plugin.clean.ui.fileindexui;

class b$1 implements Runnable {
    final /* synthetic */ b hRX;

    b$1(b bVar) {
        this.hRX = bVar;
    }

    public final void run() {
        this.hRX.notifyDataSetChanged();
    }
}
