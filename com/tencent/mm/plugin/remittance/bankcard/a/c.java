package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.jq;
import com.tencent.mm.protocal.c.jr;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitBusinessCallback";
    private b diG;
    private e diJ;
    public jr mtU;

    public c(String str, String str2) {
        a aVar = new a();
        aVar.dIG = new jq();
        aVar.dIH = new jr();
        aVar.dIF = 1340;
        aVar.uri = "/cgi-bin/mmpay-bin/busscb_tsbc";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        jq jqVar = (jq) this.diG.dID.dIL;
        jqVar.rlf = str;
        jqVar.myq = str2;
    }

    public final int getType() {
        return 1340;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitBusinessCallback", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.mtU = (jr) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneBankRemitBusinessCallback", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.mtU.hUm), this.mtU.hUn});
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        jr jrVar = (jr) ((b) qVar).dIE.dIL;
        this.uXe = jrVar.hUm;
        this.uXf = jrVar.hUn;
    }
}
