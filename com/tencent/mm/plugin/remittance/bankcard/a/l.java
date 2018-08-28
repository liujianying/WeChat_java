package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bds;
import com.tencent.mm.protocal.c.bdt;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitQueryDetail";
    private b diG;
    private e diJ;
    public bdt mud;

    public l(String str) {
        a aVar = new a();
        aVar.dIG = new bds();
        aVar.dIH = new bdt();
        aVar.dIF = 1579;
        aVar.uri = "/cgi-bin/mmpay-bin/querydetail_tsbc";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((bds) this.diG.dID.dIL).rlf = str;
        x.i("MicroMsg.NetSceneBankRemitQueryDetail", "bill id: %s", new Object[]{str});
    }

    public final int getType() {
        return 1579;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitQueryDetail", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.mud = (bdt) ((b) qVar).dIE.dIL;
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        bdt bdt = (bdt) ((b) qVar).dIE.dIL;
        this.uXe = bdt.hUm;
        this.uXf = bdt.hUn;
    }
}
