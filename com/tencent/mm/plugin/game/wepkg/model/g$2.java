package com.tencent.mm.plugin.game.wepkg.model;

class g$2 implements Runnable {
    final /* synthetic */ a kfC = null;
    final /* synthetic */ WepkgCrossProcessTask kfE;

    g$2(WepkgCrossProcessTask wepkgCrossProcessTask) {
        this.kfE = wepkgCrossProcessTask;
    }

    public final void run() {
        this.kfE.aai();
        if (this.kfC != null) {
            this.kfC.a(this.kfE);
        }
    }
}
