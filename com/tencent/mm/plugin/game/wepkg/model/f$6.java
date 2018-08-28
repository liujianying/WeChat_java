package com.tencent.mm.plugin.game.wepkg.model;

import com.tencent.mm.plugin.game.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.game.wepkg.model.g.10;
import com.tencent.mm.plugin.game.wepkg.model.g.11;
import com.tencent.mm.plugin.game.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ad;

class f$6 extends a {
    final /* synthetic */ String keN;
    final /* synthetic */ a kfx;

    f$6(String str, a aVar) {
        this.keN = str;
        this.kfx = aVar;
    }

    public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
        String str = this.keN;
        a aVar = this.kfx;
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.nc = 3006;
        wepkgCrossProcessTask.kff.kfA = str;
        wepkgCrossProcessTask.kff.kfY = false;
        if (ad.cic()) {
            d.Em().H(new 10(wepkgCrossProcessTask, aVar));
            return;
        }
        wepkgCrossProcessTask.fFC = new 11(aVar, wepkgCrossProcessTask);
        wepkgCrossProcessTask.ahA();
        WepkgMainProcessService.a(wepkgCrossProcessTask);
    }
}
