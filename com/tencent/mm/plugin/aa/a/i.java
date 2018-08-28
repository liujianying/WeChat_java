package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.b;

public final class i implements e {
    long bJC = -1;
    b dIz;

    public final void init() {
        g.Ek();
        g.Eh().dpP.a(1530, this);
    }

    public final void Wa() {
        g.Ek();
        g.Eh().dpP.b(1530, this);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.CloseAALogic", "onSceneEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            com.tencent.mm.protocal.c.e eVar = ((com.tencent.mm.plugin.aa.a.a.e) lVar).eAP;
            x.i("MicroMsg.CloseAALogic", "closeAA, response.retcode: %s", new Object[]{Integer.valueOf(eVar.hUm)});
            x.d("MicroMsg.CloseAALogic", "closeAA, response.msgxml: %s", new Object[]{eVar.qYe});
            if (eVar.hUm == 0) {
                com.tencent.mm.vending.g.g.a(this.dIz, new Object[]{Boolean.valueOf(true)});
                if (!bi.oW(eVar.qYe) && this.bJC > 0 && ((com.tencent.mm.plugin.aa.a.a.e) lVar).scene == a.ezY) {
                    h.g(this.bJC, eVar.qYe);
                }
                h.mEJ.a(407, 21, 1, false);
                return;
            } else if (eVar.hUm <= 0 || bi.oW(eVar.hUn)) {
                this.dIz.ct(Boolean.valueOf(false));
                h.mEJ.a(407, 23, 1, false);
                return;
            } else {
                this.dIz.ct(eVar.hUn);
                h.mEJ.a(407, 11, 1, false);
                return;
            }
        }
        this.dIz.ct(Boolean.valueOf(false));
        h.mEJ.a(407, 22, 1, false);
    }
}
