package com.tencent.mm.plugin.game.wepkg.model;

class g$6 implements Runnable {
    final /* synthetic */ a kfC = null;
    final /* synthetic */ WepkgCrossProcessTask kfF;

    g$6(WepkgCrossProcessTask wepkgCrossProcessTask) {
        this.kfF = wepkgCrossProcessTask;
    }

    public final void run() {
        this.kfF.aai();
        if (this.kfC != null) {
            this.kfC.a(this.kfF);
        }
    }
}
