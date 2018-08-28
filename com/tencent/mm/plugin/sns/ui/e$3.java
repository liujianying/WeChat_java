package com.tencent.mm.plugin.sns.ui;

class e$3 implements Runnable {
    final /* synthetic */ e nKD;
    final /* synthetic */ boolean nKF;

    e$3(e eVar, boolean z) {
        this.nKD = eVar;
        this.nKF = z;
    }

    public final void run() {
        if (this.nKF) {
            e eVar = this.nKD;
            if (eVar.nKB.size() > 1) {
                eVar.nKB.remove(0);
            }
        }
    }
}
