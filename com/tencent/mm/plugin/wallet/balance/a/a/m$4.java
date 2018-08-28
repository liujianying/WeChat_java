package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ab.a$a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bbl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

class m$4 implements a<Void, a$a<bbl>> {
    final /* synthetic */ b dEk;
    final /* synthetic */ m oZb;

    m$4(m mVar, b bVar) {
        this.oZb = mVar;
        this.dEk = bVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        a$a a_a = (a$a) obj;
        x.i("MicroMsg.LqtSaveFetchInteractor", "on pre redeem fund finish, cgiBack: %s, errType: %s, errCode: %s", new Object[]{a_a, Integer.valueOf(a_a.errType), Integer.valueOf(a_a.errCode)});
        if (a_a.errType == 0 && a_a.errCode == 0) {
            bbl bbl = (bbl) a_a.dIv;
            x.i("MicroMsg.LqtSaveFetchInteractor", "on pre redeem fund finsih, retcode: %s, retmsg: %s, redeem_listid: %s", new Object[]{Integer.valueOf(bbl.hwV), bbl.hwW, bbl.sdF});
            if (bbl.hwV == 0) {
                this.dEk.v(new Object[]{bbl});
                h.mEJ.a(663, 9, 1, false);
            } else {
                this.dEk.ct(bbl.hwW);
                h.mEJ.a(663, 10, 1, false);
            }
        } else {
            this.dEk.ct(Boolean.valueOf(false));
            h.mEJ.a(663, 11, 1, false);
        }
        return uQG;
    }
}
