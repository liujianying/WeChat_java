package com.tencent.mm.plugin.game.wepkg.model;

import com.tencent.mm.plugin.game.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class b$1 implements Runnable {
    final /* synthetic */ b keM;

    b$1(b bVar) {
        this.keM = bVar;
    }

    public final void run() {
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.nc = 2005;
        if (ad.cic()) {
            wepkgCrossProcessTask.aai();
        } else {
            WepkgMainProcessService.b(wepkgCrossProcessTask);
        }
        List<WepkgVersion> list = wepkgCrossProcessTask.kfg;
        if (bi.cX(list)) {
            x.i("MicroMsg.Wepkg.CleanWepkgMgr", "no need to clean wepkg");
            return;
        }
        x.i("MicroMsg.Wepkg.CleanWepkgMgr", "need to clean list.size:%s", new Object[]{Integer.valueOf(list.size())});
        for (WepkgVersion wepkgVersion : list) {
            if (wepkgVersion != null) {
                b.a(this.keM, wepkgVersion.kfA);
            }
        }
    }
}
