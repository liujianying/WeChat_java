package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.voip.b.a;

class c$1 implements e {
    final /* synthetic */ c oNT;

    c$1(c cVar) {
        this.oNT = cVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        a.eV("MicroMsg.NetSceneVoipCancelInvite", "onSceneEnd type:" + lVar.getType() + " errType:" + i + " errCode:" + i2);
    }
}
