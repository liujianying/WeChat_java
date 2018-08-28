package com.tencent.mm.plugin.game.wepkg.model;

class g$3 implements Runnable {
    final /* synthetic */ a kfC = null;
    final /* synthetic */ WepkgCrossProcessTask kfE;

    g$3(WepkgCrossProcessTask wepkgCrossProcessTask) {
        this.kfE = wepkgCrossProcessTask;
    }

    public final void run() {
        if (this.kfC != null) {
            this.kfC.a(this.kfE);
        }
        this.kfE.ahB();
    }
}
