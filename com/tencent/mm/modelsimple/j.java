package com.tencent.mm.modelsimple;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aco;
import com.tencent.mm.protocal.c.acp;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends l implements k {
    public String country;
    public String csK;
    public String csL;
    private b diG;
    private e diJ;

    public j(double d, double d2) {
        a aVar = new a();
        aVar.dIG = new aco();
        aVar.dIH = new acp();
        aVar.uri = "/cgi-bin/micromsg-bin/getcurlocation";
        aVar.dIF = 665;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        aco aco = (aco) this.diG.dID.dIL;
        aco.rjj = d;
        aco.rji = d2;
        x.d("MicroMsg.NetSceneGetCurLocation", "latitude:" + d + ", longitude:" + d2);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 665;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetCurLocation", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            acp acp = (acp) this.diG.dIE.dIL;
            this.csL = acp.eJJ;
            this.country = acp.eJQ;
            this.csK = acp.eJI;
        }
        this.diJ.a(i2, i3, str, this);
    }
}
