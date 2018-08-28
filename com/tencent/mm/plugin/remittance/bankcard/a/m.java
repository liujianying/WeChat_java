package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.beb;
import com.tencent.mm.protocal.c.bec;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitQueryTransferList";
    private b diG;
    private e diJ;
    public bec mue;

    public m() {
        a aVar = new a();
        aVar.dIG = new beb();
        aVar.dIH = new bec();
        aVar.dIF = 1378;
        aVar.uri = "/cgi-bin/mmpay-bin/tsrecordlist_tsbc";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final int getType() {
        return 1378;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitQueryTransferList", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.mue = (bec) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneBankRemitQueryTransferList", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.mue.hUm), this.mue.hUn});
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        bec bec = (bec) ((b) qVar).dIE.dIL;
        this.uXe = bec.hUm;
        this.uXf = bec.hUn;
    }
}
