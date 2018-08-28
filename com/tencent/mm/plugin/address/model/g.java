package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bfe;
import com.tencent.mm.protocal.c.bff;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends l implements k {
    private b diG;
    private e diJ;

    public g(int i) {
        a aVar = new a();
        aVar.dIG = new bfe();
        aVar.dIH = new bff();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfotouch";
        aVar.dIF = 419;
        aVar.dII = 204;
        aVar.dIJ = 1000000204;
        this.diG = aVar.KT();
        ((bfe) this.diG.dID.dIL).id = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneRcptInfoTouch", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            bff bff = (bff) ((b) qVar).dIE.dIL;
            if (bff.sgt.sgw != null) {
                x.d("MicroMsg.NetSceneRcptInfoTouch", "resp.rImpl.rcptinfolist.rcptinfolist " + bff.sgt.sgw.size());
                com.tencent.mm.plugin.address.a.a.Zv();
                com.tencent.mm.plugin.address.a.a.Zx().q(bff.sgt.sgw);
                com.tencent.mm.plugin.address.a.a.Zv();
                com.tencent.mm.plugin.address.a.a.Zx().Zz();
            }
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 419;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
