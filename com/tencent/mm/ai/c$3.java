package com.tencent.mm.ai;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.protocal.c.acl;
import com.tencent.mm.sdk.platformtools.x;

class c$3 implements a {
    final /* synthetic */ c dST;

    c$3(c cVar) {
        this.dST = cVar;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        if (lVar.getType() == 182) {
            this.dST.dGS = false;
            if (i == 0 && i2 == 0) {
                if (!this.dST.dSM.isEmpty() && this.dST.dSR.ciq()) {
                    this.dST.dSR.J(500, 500);
                }
                if (bVar != null) {
                    c.a aVar = new c.a(this.dST);
                    aVar.errType = i;
                    aVar.errCode = i2;
                    aVar.Yy = str;
                    aVar.dSZ = (acl) bVar.dIE.dIL;
                    this.dST.dSN.add(aVar);
                }
                if (!this.dST.dSN.isEmpty() && this.dST.dSS.ciq()) {
                    this.dST.dSS.J(50, 50);
                }
            } else {
                x.e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd errType:" + i + " errCode:" + i2 + " will retry");
                this.dST.dSR.J(10000, 10000);
            }
        }
        return 0;
    }
}
