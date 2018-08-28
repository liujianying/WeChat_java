package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.model.ap;
import com.tencent.mm.protocal.c.boh;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class u$2 implements Runnable {
    final /* synthetic */ u noA;
    final /* synthetic */ boolean noB;
    final /* synthetic */ boh noC;
    final /* synthetic */ ag noz;

    u$2(u uVar, boolean z, boh boh, ag agVar) {
        this.noA = uVar;
        this.noB = z;
        this.noC = boh;
        this.noz = agVar;
    }

    public final void run() {
        if (this.noB) {
            for (ap apVar : u.afl()) {
                x.i("MicroMsg.NetSceneNewSyncAlbum", "notify list ");
                apVar.HG();
            }
        }
        this.noz.sendEmptyMessage(0);
    }
}
