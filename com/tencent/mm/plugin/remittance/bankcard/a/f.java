package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.rz;
import com.tencent.mm.protocal.c.sa;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitDeleteRecord";
    private b diG;
    private e diJ;
    public String mtT;
    public sa mtX;

    public f(String str) {
        a aVar = new a();
        aVar.dIG = new rz();
        aVar.dIH = new sa();
        aVar.dIF = 1395;
        aVar.uri = "/cgi-bin/mmpay-bin/deleterecord_tsbc";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((rz) this.diG.dID.dIL).muA = str;
        this.mtT = str;
    }

    public final int getType() {
        return 1395;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitDeleteRecord", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.mtX = (sa) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneBankRemitDeleteRecord", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.mtX.hUm), this.mtX.hUn});
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        sa saVar = (sa) ((b) qVar).dIE.dIL;
        this.uXe = saVar.hUm;
        this.uXf = saVar.hUn;
    }
}
