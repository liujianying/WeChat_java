package com.tencent.mm.plugin.game.wepkg.model;

import com.tencent.mm.plugin.game.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.game.wepkg.utils.d;
import com.tencent.mm.protocal.c.pg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class WepkgVersionManager {
    public static void g(String str, int i, int i2, int i3) {
        if (!bi.oW(str)) {
            WepkgVersion Em = g.Em(str);
            if (Em == null) {
                c(str, "", i, i2, i3);
                return;
            }
            long j = Em.kfW;
            if (d.aow() >= j) {
                c(str, Em.version, i, i2, i3);
                WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                wepkgCrossProcessTask.nc = 3003;
                wepkgCrossProcessTask.kff.kfA = str;
                if (ad.cic()) {
                    d.Em().H(new 1(wepkgCrossProcessTask));
                    return;
                } else {
                    WepkgMainProcessService.a(wepkgCrossProcessTask);
                    return;
                }
            }
            x.i("MicroMsg.Wepkg.WepkgVersionManager", "currTime[%s]s < nextCheckTime[%s]s, no net request", new Object[]{Long.valueOf(d.aow()), Long.valueOf(j)});
        }
    }

    private static void c(String str, String str2, int i, int i2, int i3) {
        x.i("MicroMsg.Wepkg.WepkgVersionManager", "pkgId = " + str + ", version = " + str2 + ", scene = " + i + ", downloadTriggerType = " + i2 + ", binder = " + i3);
        LinkedList linkedList = new LinkedList();
        pg pgVar = new pg();
        pgVar.rtC = str;
        pgVar.hcr = str2;
        pgVar.otY = i;
        linkedList.add(pgVar);
        a(linkedList, i2, i3);
    }

    private static void a(LinkedList<pg> linkedList, int i, int i2) {
        if (linkedList.size() != 0) {
            WepkgNetSceneProcessTask wepkgNetSceneProcessTask = new WepkgNetSceneProcessTask();
            WepkgNetSceneProcessTask.a(wepkgNetSceneProcessTask, i);
            WepkgNetSceneProcessTask.b(wepkgNetSceneProcessTask, i2);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                pg pgVar = (pg) it.next();
                WepkgVersionManager$WepkgNetSceneProcessTask$WepkgCheckReq wepkgVersionManager$WepkgNetSceneProcessTask$WepkgCheckReq = new WepkgVersionManager$WepkgNetSceneProcessTask$WepkgCheckReq();
                wepkgVersionManager$WepkgNetSceneProcessTask$WepkgCheckReq.kfA = pgVar.rtC;
                wepkgVersionManager$WepkgNetSceneProcessTask$WepkgCheckReq.version = pgVar.hcr;
                wepkgVersionManager$WepkgNetSceneProcessTask$WepkgCheckReq.scene = pgVar.otY;
                WepkgNetSceneProcessTask.a(wepkgNetSceneProcessTask).add(wepkgVersionManager$WepkgNetSceneProcessTask$WepkgCheckReq);
            }
            if (ad.cic()) {
                d.Em().H(new 2(wepkgNetSceneProcessTask));
            } else {
                WepkgMainProcessService.a(wepkgNetSceneProcessTask);
            }
        }
    }
}
