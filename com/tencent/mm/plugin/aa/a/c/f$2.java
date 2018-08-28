package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

class f$2 implements a<Void, com.tencent.mm.ab.a.a<s>> {
    final /* synthetic */ b eBj;
    final /* synthetic */ f eBz;

    f$2(f fVar, b bVar) {
        this.eBz = fVar;
        this.eBj = bVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.ab.a.a aVar = (com.tencent.mm.ab.a.a) obj;
        x.i("MicroMsg.PaylistAAInteractor", "on urgeAAPay finish, errType: %s, errCode: %s", new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
        if (aVar.errType == 0 && aVar.errCode == 0) {
            s sVar = (s) aVar.dIv;
            x.i("MicroMsg.PaylistAAInteractor", "on urgeAAPay finish, retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(sVar.hUm), sVar.hUn});
            if (sVar.hUm == 0) {
                x.i("MicroMsg.PaylistAAInteractor", "on urgeAAPay success");
                com.tencent.mm.plugin.aa.a.ezo.vl();
                this.eBj.v(new Object[]{Boolean.valueOf(true)});
                h.mEJ.a(407, 24, 1, false);
            } else {
                if (sVar.hUm <= 0 || bi.oW(sVar.hUn)) {
                    this.eBj.ct(Boolean.valueOf(false));
                } else {
                    this.eBj.ct(sVar.hUn);
                }
                h.mEJ.a(407, 26, 1, false);
            }
        } else {
            this.eBj.ct(Boolean.valueOf(false));
            h.mEJ.a(407, 25, 1, false);
        }
        return uQG;
    }
}
