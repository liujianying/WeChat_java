package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.aa.a.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.o;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;

public final class f implements e {
    b eAc;
    boolean eAq = false;

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.eAq = false;
        if (i == 0 && i2 == 0) {
            o oVar = ((i) lVar).eAX;
            x.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(oVar.hUm), oVar.hUn});
            if (oVar.hUm == 0) {
                g.a(this.eAc, new Object[]{oVar});
                h.mEJ.a(407, 9, 1, false);
                return;
            }
            if (this.eAc != null) {
                if (oVar.qYw != null && oVar.qYw.bWA == 1 && !bi.oW(oVar.qYw.hUt) && !bi.oW(oVar.qYw.kRu) && !bi.oW(oVar.qYw.kRv) && !bi.oW(oVar.qYw.bSc)) {
                    this.eAc.ct(oVar.qYw);
                } else if (oVar.hUm <= 0 || bi.oW(oVar.hUn)) {
                    this.eAc.ct(Boolean.valueOf(false));
                } else {
                    this.eAc.ct(oVar.hUn);
                }
            }
            h.mEJ.a(407, 11, 1, false);
            return;
        }
        if (this.eAc != null) {
            this.eAc.ct(Boolean.valueOf(false));
        }
        h.mEJ.a(407, 10, 1, false);
    }
}
