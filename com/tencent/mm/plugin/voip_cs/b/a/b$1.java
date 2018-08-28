package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.mm.plugin.voip_cs.b.b;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    final /* synthetic */ b oXY;

    b$1(b bVar) {
        this.oXY = bVar;
    }

    public final boolean vD() {
        x.i("MicroMsg.voipcs.VoipCSViewManager", "voipcs invite time out!opposite not responese");
        b.bMx().bjS = 1;
        this.oXY.zc(6);
        return true;
    }
}
