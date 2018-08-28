package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.model.i;
import com.tencent.mm.protocal.c.caa;

class e$1 implements e {
    final /* synthetic */ e oNV;

    e$1(e eVar) {
        this.oNV = eVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        a.eT("MicroMsg.Voip.GetRoomInfo", "Voip onSceneEnd type:" + lVar.getType() + " errType:" + i + " errCode:" + i2);
        if (i == 0 && i2 == 0 && lVar != null) {
            caa caa = (caa) this.oNV.bLq();
            if (caa.six.rfn == 0 && !i.bJI().oNa.bLd()) {
                i.bJI().a(caa);
            }
        }
    }
}
