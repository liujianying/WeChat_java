package com.tencent.mm.plugin.game.wepkg.model;

import android.content.Intent;
import com.tencent.mm.g.a.he;
import com.tencent.mm.plugin.game.wepkg.a.b;
import com.tencent.mm.plugin.game.wepkg.a.d;
import com.tencent.mm.plugin.game.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.game.wepkg.model.WepkgVersionManager.WepkgNetSceneProcessTask;
import com.tencent.mm.plugin.game.wepkg.model.WepkgVersionManager.WepkgNetSceneProcessTask.1;
import com.tencent.mm.plugin.game.wepkg.model.g.6;
import com.tencent.mm.plugin.game.wepkg.model.g.7;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.baw;
import com.tencent.mm.protocal.c.cfq;
import com.tencent.mm.protocal.c.cfr;
import com.tencent.mm.protocal.c.cfv;
import com.tencent.mm.protocal.c.cfw;
import com.tencent.mm.protocal.c.oz;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WepkgVersionManager$WepkgNetSceneProcessTask$1$1 implements Runnable {
    final /* synthetic */ oz kgg;
    final /* synthetic */ 1 kgh;

    WepkgVersionManager$WepkgNetSceneProcessTask$1$1(1 1, oz ozVar) {
        this.kgh = 1;
        this.kgg = ozVar;
    }

    public final void run() {
        oz ozVar = this.kgg;
        int b = WepkgNetSceneProcessTask.b(this.kgh.kgf);
        int c = WepkgNetSceneProcessTask.c(this.kgh.kgf);
        if (ozVar == null) {
            return;
        }
        if (bi.cX(ozVar.rtg)) {
            x.e("MicroMsg.Wepkg.WepkgManager", "response.PkgList.size() is empty");
            return;
        }
        baw baw = (baw) ozVar.rtg.get(0);
        if (baw != null) {
            String str = baw.rtC;
            cfv cfv = baw.sdh;
            cfr cfr = baw.sdj;
            if (!bi.oW(str)) {
                if (cfr != null) {
                    if (cfr.sAj) {
                        x.i("MicroMsg.Wepkg.WepkgManager", "wepkg reload now. binder:%d", new Object[]{Integer.valueOf(c)});
                        ad.getContext().sendBroadcast(new Intent("com.tencent.mm.ACTION_RELOAD").putExtra("hashcode", c), "com.tencent.mm.permission.MM_MESSAGE");
                        x.i("MicroMsg.Wepkg.WepkgManager", "sync clear wepkg info, pkgid:%s", new Object[]{str});
                        d.aVo().DU(str);
                        b.aVn().DU(str);
                        f.Ek(com.tencent.mm.plugin.game.wepkg.utils.d.Et(str));
                        if (com.tencent.mm.plugin.game.wepkg.utils.b.kgk != null) {
                            com.tencent.mm.plugin.game.wepkg.utils.b.kgk.Es(str);
                        }
                        h.mEJ.a(859, 17, 1, false);
                    }
                    if (cfr.sAi) {
                        f.Ei(str);
                        return;
                    }
                }
                if (cfv != null && cfv.sAq != null) {
                    if (bi.oW(cfv.sAq.sAk)) {
                        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                        wepkgCrossProcessTask.nc = 2004;
                        wepkgCrossProcessTask.kff.kfA = str;
                        if (ad.cic()) {
                            com.tencent.mm.plugin.game.wepkg.utils.d.Em().H(new 6(wepkgCrossProcessTask));
                        } else {
                            wepkgCrossProcessTask.fFC = new 7(wepkgCrossProcessTask);
                            wepkgCrossProcessTask.ahA();
                            WepkgMainProcessService.a(wepkgCrossProcessTask);
                        }
                        h.mEJ.a(859, 18, 1, false);
                        return;
                    }
                    boolean z = cfv.sAq.sAl;
                    long j = (long) cfv.sAq.sAm;
                    long j2 = (long) cfv.sAq.sAn;
                    WepkgCrossProcessTask wepkgCrossProcessTask2 = new WepkgCrossProcessTask();
                    wepkgCrossProcessTask2.nc = 3004;
                    wepkgCrossProcessTask2.kff.kfA = str;
                    wepkgCrossProcessTask2.kff.kfR = z;
                    wepkgCrossProcessTask2.kff.kfS = j;
                    wepkgCrossProcessTask2.kff.kfT = j2;
                    if (ad.cic()) {
                        wepkgCrossProcessTask2.aai();
                    } else {
                        WepkgMainProcessService.b(wepkgCrossProcessTask2);
                    }
                    WepkgCrossProcessTask wepkgCrossProcessTask3 = new WepkgCrossProcessTask();
                    wepkgCrossProcessTask3.nc = 3009;
                    wepkgCrossProcessTask3.kff.kfA = str;
                    if (ad.cic()) {
                        wepkgCrossProcessTask3.aai();
                    } else {
                        WepkgMainProcessService.b(wepkgCrossProcessTask3);
                    }
                    wepkgCrossProcessTask3 = new WepkgCrossProcessTask();
                    wepkgCrossProcessTask3.nc = 4006;
                    wepkgCrossProcessTask3.kfh.kfA = str;
                    if (ad.cic()) {
                        wepkgCrossProcessTask3.aai();
                    } else {
                        WepkgMainProcessService.b(wepkgCrossProcessTask3);
                    }
                    h aVz = h.aVz();
                    if (baw == null || baw.sdi == null) {
                        x.i("MicroMsg.Wepkg.WepkgUpdater", "dont need to update wepkg");
                        if (baw != null) {
                            aVz.aC(baw.rtC, false);
                            return;
                        }
                        return;
                    }
                    cfq cfq = baw.sdi.sAu;
                    cfw cfw = baw.sdi.sAv;
                    if (cfq == null && cfw == null) {
                        x.i("MicroMsg.Wepkg.WepkgUpdater", "bigPackage is null and preloadFiles is null");
                        f.Ei(baw.rtC);
                        return;
                    }
                    g.a(baw, b);
                    x.i("MicroMsg.Wepkg.WepkgUpdater", "downloadTriggerType:%d", new Object[]{Integer.valueOf(b)});
                    switch (b) {
                        case -1:
                        case 0:
                            aVz.aC(baw.rtC, false);
                            return;
                        case 1:
                            if (com.tencent.mm.plugin.game.wepkg.utils.d.dE(ad.getContext())) {
                                aVz.aC(baw.rtC, false);
                                return;
                            }
                            return;
                        case 2:
                            he heVar = new he();
                            a.sFg.m(heVar);
                            if (heVar.bQs.bQt) {
                                aVz.aC(baw.rtC, false);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }
}
