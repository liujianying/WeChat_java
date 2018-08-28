package com.tencent.mm.plugin.game.wepkg.utils;

import com.tencent.mm.plugin.game.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.game.wepkg.model.a;

class d$1 implements Runnable {
    final /* synthetic */ a kfC;
    final /* synthetic */ WepkgCrossProcessTask kfs;

    d$1(WepkgCrossProcessTask wepkgCrossProcessTask, a aVar) {
        this.kfs = wepkgCrossProcessTask;
        this.kfC = aVar;
    }

    public final void run() {
        this.kfs.aai();
        if (this.kfC != null) {
            this.kfC.a(this.kfs);
        }
    }
}
