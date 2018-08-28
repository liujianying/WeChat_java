package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.protocal.c.cax;

class m$1 implements e {
    final /* synthetic */ m oOd;

    m$1(m mVar) {
        this.oOd = mVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        a.eU("MicroMsg.NetSceneVoipSync", "onSceneEnd type:" + lVar.getType() + " errType:" + i + " errCode:" + i2);
        try {
            if (((cax) this.oOd.bLq()).rxG != this.oOd.oKs.oJX.kpo) {
                a.eT("MicroMsg.NetSceneVoipSync", "syncOnSceneEnd: recv roomId != current roomid");
                return;
            }
        } catch (Exception e) {
        }
        if (i != 0) {
            a.eT("MicroMsg.NetSceneVoipSync", "VoipSync Failed, type:" + lVar.getType() + " errType:" + i + " errCode:" + i2);
            this.oOd.oKs.oJX.oPS.oKQ = 11;
            this.oOd.oKs.oJX.oPS.oKS = i2;
            this.oOd.oKs.oJX.oPS.oKR = i2;
            this.oOd.oKs.oJX.oPS.oLi = 3;
            if (i == 1) {
                this.oOd.oKs.oJX.oPS.oLc = 8;
            } else {
                this.oOd.oKs.oJX.oPS.oLc = 99;
            }
            this.oOd.oKs.o(1, -9004, "");
            return;
        }
        this.oOd.oKs.oKa.o(lVar);
    }
}
