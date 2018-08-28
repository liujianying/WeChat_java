package com.tencent.mm.plugin.game.wepkg.model;

class g$1 implements Runnable {
    final /* synthetic */ a kfC;
    final /* synthetic */ WepkgDownloadProcessTask kfD;

    g$1(a aVar, WepkgDownloadProcessTask wepkgDownloadProcessTask) {
        this.kfC = aVar;
        this.kfD = wepkgDownloadProcessTask;
    }

    public final void run() {
        if (this.kfC != null) {
            this.kfC.a(this.kfD);
        }
        this.kfD.ahB();
    }
}
