package com.tencent.mm.plugin.product.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ago;
import com.tencent.mm.protocal.c.agp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class h extends l implements k {
    private b diG;
    private e diJ;
    public String lRg;
    public m lRh;
    public List<n> lRi;

    public h(m mVar, String str) {
        a aVar = new a();
        aVar.dIG = new ago();
        aVar.dIH = new agp();
        aVar.uri = "/cgi-bin/micromsg-bin/getproductdetail";
        this.diG = aVar.KT();
        ago ago = (ago) this.diG.dID.dIL;
        this.lRg = str;
        ago.rJU = str;
        x.d("MicroMsg.NetSceneMallGetProductDetail", "pid " + str);
        ago.hcD = 0;
        this.lRh = mVar;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        agp agp = (agp) ((b) qVar).dIE.dIL;
        if (!bi.oW(agp.rJW)) {
            x.d("MicroMsg.NetSceneMallGetProductDetail", "resp.ProductInfo " + agp.rJW);
            this.lRh = m.a(this.lRh, agp.rJW);
        }
        if (i3 == 0 && agp.rmN != 0) {
            i3 = agp.rmN;
            str = agp.rmO;
        }
        if (!bi.oW(agp.rJX)) {
            x.d("MicroMsg.NetSceneMallGetProductDetail", "resp.RecommendInfo " + agp.rJX);
            this.lRi = n.parse(agp.rJX);
        }
        x.d("MicroMsg.NetSceneMallGetProductDetail", "errCode " + i3 + ", errMsg " + str);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 553;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
