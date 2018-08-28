package com.tencent.mm.plugin.product.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aet;
import com.tencent.mm.protocal.c.aeu;
import com.tencent.mm.protocal.c.cf;
import com.tencent.mm.protocal.c.um;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class g extends l implements k {
    private b diG;
    private e diJ;
    public LinkedList<um> lQY;
    public String lRg;

    public g(String str, String str2, cf cfVar) {
        a aVar = new a();
        aVar.dIG = new aet();
        aVar.dIH = new aeu();
        aVar.uri = "/cgi-bin/micromsg-bin/getlastestexpressinfo";
        this.diG = aVar.KT();
        aet aet = (aet) this.diG.dID.dIL;
        this.lRg = str;
        aet.rlw = str;
        x.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "pid " + str);
        aet.rmM = str2;
        aet.rII = cfVar;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        aeu aeu = (aeu) ((b) qVar).dIE.dIL;
        if (i2 == 0 && i3 == 0 && aeu.rmN == 0) {
            x.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "resp.ExpressCount " + aeu.rIK);
            this.lQY = aeu.rIJ;
        }
        if (i3 == 0 && aeu.rmN != 0) {
            i3 = aeu.rmN;
            str = aeu.rmO;
        }
        x.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "errCode " + i3 + ", errMsg " + str);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 578;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
