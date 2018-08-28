package com.tencent.mm.plugin.product.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bnx;
import com.tencent.mm.protocal.c.bro;
import com.tencent.mm.protocal.c.brp;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.m;

public final class l extends m implements k {
    private b diG;
    private e diJ;
    public String lRk;

    public l(bnx bnx, String str) {
        a aVar = new a();
        aVar.dIG = new bro();
        aVar.dIH = new brp();
        aVar.uri = "/cgi-bin/micromsg-bin/submitmallorder";
        aVar.dIF = 556;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bro bro = (bro) this.diG.dID.dIL;
        bro.spz = bnx;
        bro.spB = str;
    }

    public final int getType() {
        return 556;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void e(int i, int i2, String str, q qVar) {
        brp brp = (brp) ((b) qVar).dIE.dIL;
        if (i == 0 && i2 == 0) {
            x.d("MicroMsg.NetSceneMallSubmitMallOrder", "resp.ReqKey " + brp.spA);
            this.lRk = brp.spA;
        }
        x.d("MicroMsg.NetSceneMallSubmitMallOrder", "errCode " + i2 + ", errMsg " + str);
        this.diJ.a(i, i2, str, this);
    }
}
