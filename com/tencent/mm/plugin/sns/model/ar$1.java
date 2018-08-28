package com.tencent.mm.plugin.sns.model;

class ar$1 implements Runnable {
    final /* synthetic */ ar nrO;

    ar$1(ar arVar) {
        this.nrO = arVar;
    }

    public final void run() {
        if (this.nrO.emO != null) {
            this.nrO.emO.stop();
        }
        this.nrO.emO = null;
    }
}
