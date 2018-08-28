package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

class j$1 implements a<Void, com.tencent.mm.ab.a.a<bdo>> {
    final /* synthetic */ b dEk;
    final /* synthetic */ j oYS;

    j$1(j jVar, b bVar) {
        this.oYS = jVar;
        this.dEk = bVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.ab.a.a aVar = (com.tencent.mm.ab.a.a) obj;
        x.i("MicroMsg.LqtDetailInteractor", "on qryusrfunddetail finish, errType: %s, errCode: %s", new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
        if (aVar.errType == 0 && aVar.errCode == 0) {
            bdo bdo = (bdo) aVar.dIv;
            x.i("MicroMsg.LqtDetailInteractor", "on qryusrfunddetail finsih, retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(bdo.hwV), bdo.hwW});
            if (bdo.hwV == 0) {
                this.dEk.v(new Object[]{bdo});
                h.mEJ.a(663, 0, 1, false);
            } else {
                this.dEk.ct(bdo.hwW);
                h.mEJ.a(663, 1, 1, false);
            }
        } else {
            this.dEk.ct(Boolean.valueOf(false));
            h.mEJ.a(663, 2, 1, false);
        }
        return uQG;
    }
}
