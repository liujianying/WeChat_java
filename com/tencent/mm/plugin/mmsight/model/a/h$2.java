package com.tencent.mm.plugin.mmsight.model.a;

class h$2 implements Runnable {
    final /* synthetic */ h lij;

    h$2(h hVar) {
        this.lij = hVar;
    }

    public final void run() {
        if (this.lij.bDp != null) {
            this.lij.lif = true;
            this.lij.bDp.we();
        }
    }
}
