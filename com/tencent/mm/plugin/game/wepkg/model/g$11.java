package com.tencent.mm.plugin.game.wepkg.model;

class g$11 implements Runnable {
    final /* synthetic */ a kfC;
    final /* synthetic */ WepkgCrossProcessTask kfF;

    g$11(a aVar, WepkgCrossProcessTask wepkgCrossProcessTask) {
        this.kfC = aVar;
        this.kfF = wepkgCrossProcessTask;
    }

    public final void run() {
        if (this.kfC != null) {
            this.kfC.a(this.kfF);
        }
        this.kfF.ahB();
    }
}
