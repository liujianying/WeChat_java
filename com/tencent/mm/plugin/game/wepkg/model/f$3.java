package com.tencent.mm.plugin.game.wepkg.model;

import com.tencent.mm.plugin.game.wepkg.model.f.a;
import com.tencent.mm.plugin.game.wepkg.utils.d;
import java.io.File;

class f$3 implements Runnable {
    final /* synthetic */ WepkgCrossProcessTask kfs;
    final /* synthetic */ String kft;
    final /* synthetic */ File kfu;
    final /* synthetic */ a kfv;

    f$3(WepkgCrossProcessTask wepkgCrossProcessTask, String str, File file, a aVar) {
        this.kfs = wepkgCrossProcessTask;
        this.kft = str;
        this.kfu = file;
        this.kfv = aVar;
    }

    public final void run() {
        if (this.kfs.bGZ) {
            d.Em().H(new 1(this));
        }
        this.kfs.ahB();
    }
}
