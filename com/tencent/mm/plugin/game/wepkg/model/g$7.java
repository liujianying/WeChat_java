package com.tencent.mm.plugin.game.wepkg.model;

class g$7 implements Runnable {
    final /* synthetic */ a kfC = null;
    final /* synthetic */ WepkgCrossProcessTask kfF;

    g$7(WepkgCrossProcessTask wepkgCrossProcessTask) {
        this.kfF = wepkgCrossProcessTask;
    }

    public final void run() {
        if (this.kfC != null) {
            this.kfC.a(this.kfF);
        }
        this.kfF.ahB();
    }
}
