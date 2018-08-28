package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bcp;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

class m$1 implements a<Void, com.tencent.mm.ab.a.a<bcp>> {
    final /* synthetic */ b dEk;
    final /* synthetic */ m oZb;

    m$1(m mVar, b bVar) {
        this.oZb = mVar;
        this.dEk = bVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.ab.a.a aVar = (com.tencent.mm.ab.a.a) obj;
        x.i("MicroMsg.LqtSaveFetchInteractor", "on purchaseFund finish, cgiBack: %s, errType: %s, errCode: %s", new Object[]{aVar, Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
        if (aVar.errType == 0 && aVar.errCode == 0) {
            bcp bcp = (bcp) aVar.dIv;
            x.i("MicroMsg.LqtSaveFetchInteractor", "on purchaseFund finsih, retcode: %s, retmsg: %s, prepayid: %s, out_trade_no: %s", new Object[]{Integer.valueOf(bcp.hwV), bcp.hwW, bcp.seN, bcp.qYx});
            if (bcp.hwV == 0) {
                this.dEk.v(new Object[]{aVar.dIv});
                h.mEJ.a(663, 3, 1, false);
            } else {
                this.dEk.ct(bcp.hwW);
                h.mEJ.a(664, 4, 1, false);
            }
        } else {
            this.dEk.ct(Boolean.valueOf(false));
            h.mEJ.a(664, 5, 1, false);
        }
        return uQG;
    }
}
