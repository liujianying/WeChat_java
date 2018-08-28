package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.pk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

class j$2 implements a<Void, com.tencent.mm.ab.a.a<pk>> {
    final /* synthetic */ b dEk;
    final /* synthetic */ j oYS;

    j$2(j jVar, b bVar) {
        this.oYS = jVar;
        this.dEk = bVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.ab.a.a aVar = (com.tencent.mm.ab.a.a) obj;
        x.i("MicroMsg.LqtDetailInteractor", "on close lqt account finish, errType: %s, errCode: %s", new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
        j.bMP();
        if (aVar.errType == 0 && aVar.errCode == 0) {
            pk pkVar = (pk) aVar.dIv;
            x.i("MicroMsg.LqtDetailInteractor", "on close lqt account finsih, retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(pkVar.hwV), pkVar.hwW});
            if (pkVar.hwV == 0) {
                this.dEk.v(new Object[]{pkVar});
                h.mEJ.a(663, 15, 1, false);
            } else {
                this.dEk.ct(pkVar.hwW);
                h.mEJ.a(663, 16, 1, false);
            }
        } else {
            this.dEk.ct(Boolean.valueOf(false));
            h.mEJ.a(663, 17, 1, false);
        }
        return uQG;
    }
}
