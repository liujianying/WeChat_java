package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.voip.b.a;

class f$1 implements e {
    final /* synthetic */ f oNW;

    f$1(f fVar) {
        this.oNW = fVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (i != 0 && i2 == 231) {
            a.eT(this.oNW.TAG, "Voip heartbeat Failed, type:" + lVar.getType() + " errType:" + i + " errCode:" + i2);
            this.oNW.oKs.oJX.oPS.oKQ = 111;
            this.oNW.oKs.oJX.oPS.oKR = i2;
            this.oNW.oKs.oJX.oPS.oLi = 2;
            this.oNW.oKs.o(1, -9004, "");
        }
    }
}
