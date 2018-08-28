package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aaa;
import com.tencent.mm.protocal.c.zz;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitGetBankList";
    private b diG;
    private e diJ;
    public aaa mtZ;

    public h() {
        a aVar = new a();
        aVar.dIG = new zz();
        aVar.dIH = new aaa();
        aVar.dIF = 1399;
        aVar.uri = "/cgi-bin/mmpay-bin/getbanklist_tsbc";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final int getType() {
        return 1399;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitGetBankList", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.mtZ = (aaa) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneBankRemitGetBankList", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.mtZ.hUm), this.mtZ.hUn});
        if (!(this.hUU || this.mtZ.hUm == 0)) {
            this.hUV = true;
        }
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        aaa aaa = (aaa) ((b) qVar).dIE.dIL;
        this.uXe = aaa.hUm;
        this.uXf = aaa.hUn;
    }
}
