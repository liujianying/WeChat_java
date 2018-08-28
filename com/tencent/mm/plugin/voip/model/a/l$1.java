package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.voip.b.a;

class l$1 implements e {
    final /* synthetic */ l oOc;

    l$1(l lVar) {
        this.oOc = lVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        a.eV("MicroMsg.NetSceneVoipStatReport", "onSceneEnd type:" + lVar.getType() + " errType:" + i + " errCode:" + i2);
    }
}
