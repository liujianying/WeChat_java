package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.voip.b.a;

class j$1 implements e {
    final /* synthetic */ j oOa;

    j$1(j jVar) {
        this.oOa = jVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        a.eU("MicroMsg.NetSceneVoipSpeedResult", "VoipContext onVoipSpeedResultResp errType=" + i + " errCode=" + i2 + " errMsg=" + str);
        this.oOa.oKs.bJL();
    }
}
