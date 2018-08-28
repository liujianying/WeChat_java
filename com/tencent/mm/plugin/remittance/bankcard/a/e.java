package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.rx;
import com.tencent.mm.protocal.c.ry;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitDeleteHistory";
    private b diG;
    private com.tencent.mm.ab.e diJ;
    public String hTH;
    public ry mtW;

    public e(String str) {
        a aVar = new a();
        aVar.dIG = new rx();
        aVar.dIH = new ry();
        aVar.dIF = 1737;
        aVar.uri = "/cgi-bin/mmpay-bin/deletehistoryrecord_tsbc";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((rx) this.diG.dID.dIL).rlf = str;
        this.hTH = str;
    }

    public final int getType() {
        return 1737;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitDeleteHistory", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.mtW = (ry) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneBankRemitDeleteHistory", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.mtW.hUm), this.mtW.hUn});
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        ry ryVar = (ry) ((b) qVar).dIE.dIL;
        this.uXe = ryVar.hUm;
        this.uXf = ryVar.hUn;
    }
}
