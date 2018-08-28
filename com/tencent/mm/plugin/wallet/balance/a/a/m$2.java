package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ab.a$a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bdm;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

class m$2 implements a<Void, a$a<bdm>> {
    final /* synthetic */ b dEk;
    final /* synthetic */ m oZb;

    m$2(m mVar, b bVar) {
        this.oZb = mVar;
        this.dEk = bVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        a$a a_a = (a$a) obj;
        x.i("MicroMsg.LqtSaveFetchInteractor", "on qry purchase result finish, cgiBack: %s, errType: %s, errCode: %s", new Object[]{a_a, Integer.valueOf(a_a.errType), Integer.valueOf(a_a.errCode)});
        if (a_a.errType == 0 && a_a.errCode == 0) {
            bdm bdm = (bdm) a_a.dIv;
            x.i("MicroMsg.LqtSaveFetchInteractor", "on qry purchase result finsih, retcode: %s, retmsg: %s, purchase_state: %s", new Object[]{Integer.valueOf(bdm.hwV), bdm.hwW, Integer.valueOf(bdm.sfv)});
            if (bdm.hwV == 0) {
                this.dEk.v(new Object[]{bdm});
                h.mEJ.a(663, 6, 1, false);
            } else {
                this.dEk.ct(bdm.hwW);
                h.mEJ.a(663, 7, 1, false);
            }
        } else {
            this.dEk.ct(Boolean.valueOf(false));
            h.mEJ.a(663, 8, 1, false);
        }
        return uQG;
    }
}
