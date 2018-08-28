package com.tencent.mm.plugin.game.wepkg.utils;

import com.tencent.mm.plugin.game.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.game.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.game.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.game.wepkg.model.h;
import com.tencent.mm.plugin.game.wepkg.utils.c.2;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;

class c$2$1 implements Runnable {
    final /* synthetic */ 2 kgr;

    c$2$1(2 2) {
        this.kgr = 2;
    }

    public final void run() {
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.nc = 2003;
        if (ad.cic()) {
            wepkgCrossProcessTask.aai();
        } else {
            WepkgMainProcessService.b(wepkgCrossProcessTask);
        }
        WepkgVersion wepkgVersion = wepkgCrossProcessTask.kff;
        if (wepkgVersion != null && !bi.oW(wepkgVersion.kfA)) {
            h.aVz().aC(wepkgVersion.kfA, true);
        }
    }
}
