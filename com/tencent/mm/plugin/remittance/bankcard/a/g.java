package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.zx;
import com.tencent.mm.protocal.c.zy;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitGetBankInfo";
    public String bKg;
    private b diG;
    private e diJ;
    public zy mtY;

    public g(String str, String str2) {
        a aVar = new a();
        aVar.dIG = new zx();
        aVar.dIH = new zy();
        aVar.dIF = 1542;
        aVar.uri = "/cgi-bin/mmpay-bin/getbankinfo_tsbc";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((zx) this.diG.dID.dIL).rrh = str;
        this.bKg = str2;
    }

    public final int getType() {
        return 1542;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitGetBankInfo", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.mtY = (zy) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneBankRemitGetBankInfo", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.mtY.hUm), this.mtY.hUn});
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        zy zyVar = (zy) ((b) qVar).dIE.dIL;
        this.uXe = zyVar.hUm;
        this.uXf = zyVar.hUn;
    }
}
