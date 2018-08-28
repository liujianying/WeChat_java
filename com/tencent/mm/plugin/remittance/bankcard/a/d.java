package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.nb;
import com.tencent.mm.protocal.c.nc;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitCheckBankBind";
    private b diG;
    private e diJ;
    public nc mtV;

    public d(String str, String str2, String str3, String str4) {
        a aVar = new a();
        aVar.dIG = new nb();
        aVar.dIH = new nc();
        aVar.dIF = 1349;
        aVar.uri = "/cgi-bin/mmpay-bin/checkbankbind_tsbc";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        nb nbVar = (nb) this.diG.dID.dIL;
        nbVar.rrg = str;
        nbVar.rrh = str2;
        nbVar.knE = str3;
        nbVar.lMV = str4;
    }

    public final int getType() {
        return 1349;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitCheckBankBind", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.mtV = (nc) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneBankRemitCheckBankBind", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.mtV.hUm), this.mtV.hUn});
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        nc ncVar = (nc) ((b) qVar).dIE.dIL;
        this.uXe = ncVar.hUm;
        this.uXf = ncVar.hUn;
    }
}
