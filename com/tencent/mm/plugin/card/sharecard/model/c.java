package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ahw;
import com.tencent.mm.protocal.c.ahx;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends l implements k {
    private final b diG;
    private e diJ;
    public String hwU;

    public c(String str) {
        a aVar = new a();
        aVar.dIG = new ahw();
        aVar.dIH = new ahx();
        aVar.uri = "/cgi-bin/micromsg-bin/getsharecard";
        aVar.dIF = 904;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((ahw) this.diG.dID.dIL).cac = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(904), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            ahx ahx = (ahx) this.diG.dIE.dIL;
            x.v("MicroMsg.NetSceneGetShareCard", "json:" + ahx.hwU);
            this.hwU = ahx.hwU;
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 904;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
