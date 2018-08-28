package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.avb;
import com.tencent.mm.protocal.c.avc;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitModifyExplain";
    private b diG;
    private e diJ;
    public String fky;
    public String mtT;
    public avc mub;

    public j(String str, String str2) {
        a aVar = new a();
        aVar.dIG = new avb();
        aVar.dIH = new avc();
        aVar.dIF = 1590;
        aVar.uri = "/cgi-bin/mmpay-bin/modifyexplain_tsbc";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        avb avb = (avb) this.diG.dID.dIL;
        avb.muA = str;
        avb.muD = str2;
        this.mtT = str;
        this.fky = str2;
    }

    public final int getType() {
        return 1590;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitModifyExplain", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.mub = (avc) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneBankRemitModifyExplain", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.mub.hUm), this.mub.hUn});
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        avc avc = (avc) ((b) qVar).dIE.dIL;
        this.uXe = avc.hUm;
        this.uXf = avc.hUn;
    }
}
