package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bft;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

class m$3 implements a<Void, com.tencent.mm.ab.a.a<bft>> {
    final /* synthetic */ b dEk;
    final /* synthetic */ m oZb;

    m$3(m mVar, b bVar) {
        this.oZb = mVar;
        this.dEk = bVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.ab.a.a aVar = (com.tencent.mm.ab.a.a) obj;
        x.i("MicroMsg.LqtSaveFetchInteractor", "on redeem fund finish, cgiBack: %s, errType: %s, errCode: %s", new Object[]{aVar, Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
        if (aVar.errType == 0 && aVar.errCode == 0) {
            bft bft = (bft) aVar.dIv;
            x.i("MicroMsg.LqtSaveFetchInteractor", "on redeem fund finsih, retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(bft.hwV), bft.hwW});
            if (bft.hwV == 0) {
                this.dEk.v(new Object[]{bft});
                h.mEJ.a(663, 12, 1, false);
            } else {
                this.dEk.ct(bft.hwW);
                h.mEJ.a(663, 13, 1, false);
            }
        } else {
            this.dEk.ct(Boolean.valueOf(false));
            h.mEJ.a(663, 14, 1, false);
        }
        return uQG;
    }
}
