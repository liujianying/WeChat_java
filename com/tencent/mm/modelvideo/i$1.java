package com.tencent.mm.modelvideo;

class i$1 implements Runnable {
    final /* synthetic */ i emQ;

    i$1(i iVar) {
        this.emQ = iVar;
    }

    public final void run() {
        if (this.emQ.emO != null) {
            this.emQ.emO.stop();
        }
        this.emQ.emO = null;
    }
}
