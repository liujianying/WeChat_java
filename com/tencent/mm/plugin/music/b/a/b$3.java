package com.tencent.mm.plugin.music.b.a;

class b$3 implements Runnable {
    final /* synthetic */ int eNW;
    final /* synthetic */ b lAc;

    b$3(b bVar, int i) {
        this.lAc = bVar;
        this.eNW = i;
    }

    public final void run() {
        if (this.lAc.bit()) {
            this.lAc.lzZ.n(this.lAc.bTF);
        }
    }
}
