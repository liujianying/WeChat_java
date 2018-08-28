package com.tencent.mm.plugin.product.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bnx;
import com.tencent.mm.protocal.c.brm;
import com.tencent.mm.protocal.c.brn;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends l implements com.tencent.mm.network.k {
    private b diG;
    private e diJ;
    public String lRk;

    public k(bnx bnx) {
        a aVar = new a();
        aVar.dIG = new brm();
        aVar.dIH = new brn();
        aVar.uri = "/cgi-bin/micromsg-bin/submitmallfreeorder";
        aVar.dIF = 557;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((brm) this.diG.dID.dIL).spz = bnx;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        brn brn = (brn) ((b) qVar).dIE.dIL;
        if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneMallSubmitMallFreeOrder", "resp.PrepareId " + brn.spA);
            this.lRk = brn.spA;
        }
        x.d("MicroMsg.NetSceneMallSubmitMallFreeOrder", "errCode " + i3 + ", errMsg " + str);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 557;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
