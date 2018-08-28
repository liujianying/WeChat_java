package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.adq;
import com.tencent.mm.protocal.c.adr;
import com.tencent.mm.sdk.platformtools.x;

public final class ak extends l implements k {
    private final b diG;
    private e diJ = null;

    public ak() {
        a aVar = new a();
        aVar.dIG = new adq();
        aVar.dIH = new adr();
        aVar.uri = "/cgi-bin/micromsg-bin/getfavinfo";
        aVar.dIF = 438;
        aVar.dII = 217;
        aVar.dIJ = 1000000217;
        this.diG = aVar.KT();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetFavInfo", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            adr adr = (adr) ((b) qVar).dIE.dIL;
            x.v("MicroMsg.NetSceneGetFavInfo", "used:%d  total:%d  mxDown:%d  mxUp:%d  mxFile:%d", new Object[]{Long.valueOf(adr.rcg), Long.valueOf(adr.hcc), Integer.valueOf(adr.rId), Integer.valueOf(adr.rIc), Integer.valueOf(adr.rIb)});
            b.dh(adr.rcg);
            b.di(adr.hcc);
            b.dk((long) adr.rId);
            b.dl((long) adr.rIc);
            b.dm((long) adr.rIb);
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 438;
    }
}
