package com.tencent.mm.plugin.game.wepkg.model;

class g$4 implements Runnable {
    final /* synthetic */ a kfC;
    final /* synthetic */ WepkgCrossProcessTask kfF;

    g$4(WepkgCrossProcessTask wepkgCrossProcessTask, a aVar) {
        this.kfF = wepkgCrossProcessTask;
        this.kfC = aVar;
    }

    public final void run() {
        this.kfF.aai();
        if (this.kfC != null) {
            this.kfC.a(this.kfF);
        }
    }
}
