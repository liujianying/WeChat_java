package com.tencent.mm.plugin.game.wepkg.utils;

import com.tencent.mm.plugin.game.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.game.wepkg.model.a;
import com.tencent.mm.sdk.platformtools.x;

class d$2 implements Runnable {
    final /* synthetic */ a kfC;
    final /* synthetic */ WepkgCrossProcessTask kfs;
    final /* synthetic */ long kgy;

    d$2(long j, a aVar, WepkgCrossProcessTask wepkgCrossProcessTask) {
        this.kgy = j;
        this.kfC = aVar;
        this.kfs = wepkgCrossProcessTask;
    }

    public final void run() {
        x.i("MicroMsg.Wepkg.WepkgUtil", "bind service time:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - this.kgy)});
        if (this.kfC != null) {
            this.kfC.a(this.kfs);
        }
        this.kfs.ahB();
    }
}
