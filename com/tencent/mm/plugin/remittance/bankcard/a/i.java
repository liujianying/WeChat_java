package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdw;
import com.tencent.mm.protocal.c.bdx;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends b {
    private b diG;
    private e diJ;
    public int limit;
    public bdx mua;

    public i(int i, int i2) {
        a aVar = new a();
        aVar.dIG = new bdw();
        aVar.dIH = new bdx();
        aVar.dIF = 1511;
        aVar.uri = "/cgi-bin/mmpay-bin/historylist_tsbc";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bdw bdw = (bdw) this.diG.dID.dIL;
        bdw.limit = i;
        bdw.offset = i2;
        this.limit = i;
        x.i("MicroMsg.NetSceneBankRemitHistoryList", "limit: %s, offset: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final int getType() {
        return 1511;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitHistoryList", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.mua = (bdx) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneBankRemitHistoryList", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.mua.hUm), this.mua.hUn});
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        bdx bdx = (bdx) ((b) qVar).dIE.dIL;
        this.uXe = bdx.hUm;
        this.uXf = bdx.hUn;
    }
}
