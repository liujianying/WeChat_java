package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bgt;
import com.tencent.mm.protocal.c.bgu;
import com.tencent.mm.sdk.platformtools.x;

public final class u extends l implements k {
    private final b diG;
    private e diJ;

    public u(float f, float f2, String str, String str2, int i) {
        a aVar = new a();
        aVar.dIG = new bgt();
        aVar.dIH = new bgu();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/reportlocation";
        aVar.dIF = 1253;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bgt bgt = (bgt) this.diG.dID.dIL;
        bgt.latitude = (double) f;
        bgt.longitude = (double) f2;
        bgt.cac = str;
        bgt.huU = str2;
        bgt.shE = i;
    }

    public final int getType() {
        return 1253;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneCardReportLocation", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        this.diJ.a(i2, i3, str, this);
    }
}
