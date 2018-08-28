package com.tencent.mm.modelsimple;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

class t$1 implements Runnable {
    final /* synthetic */ bd dAB;
    final /* synthetic */ t ego;

    t$1(t tVar, bd bdVar) {
        this.ego = tVar;
        this.dAB = bdVar;
    }

    public final void run() {
        x.i("MicroMsg.NetSceneRevokeMsg", "delete invoke message! msg:%s", new Object[]{Long.valueOf(this.dAB.field_msgId)});
        this.dAB.setType(10002);
        t.a(t.a(this.ego), "", this.dAB, "");
        au.HU();
        c.FT().a(this.dAB.field_msgId, this.dAB);
    }
}
