package com.tencent.mm.ui.base.sortview;

class b$1 implements Runnable {
    final /* synthetic */ b tDF;

    b$1(b bVar) {
        this.tDF = bVar;
    }

    public final void run() {
        this.tDF.notifyDataSetChanged();
    }
}
