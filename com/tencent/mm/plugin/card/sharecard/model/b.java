package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.abp;
import com.tencent.mm.protocal.c.abq;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;

public final class b extends l implements k {
    private final com.tencent.mm.ab.b diG;
    private e diJ;
    public String hwU;
    public String hym = "";

    public b(double d, double d2, String str) {
        a aVar = new a();
        aVar.dIG = new abp();
        aVar.dIH = new abq();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/getcardshomepage";
        aVar.dIF = 1164;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        abp abp = (abp) this.diG.dID.dIL;
        abp.latitude = d;
        abp.longitude = d2;
        abp.hym = str;
        abp.rGm = (String) g.Ei().DT().get(aa.a.sPU, "");
        x.d("MicroMsg.NetSceneGetCardsHomePageLayout", "red_buff:" + abp.rGm);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetCardsHomePageLayout", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(1164), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            abq abq = (abq) this.diG.dIE.dIL;
            x.v("MicroMsg.NetSceneGetCardsHomePageLayout", "json:" + abq.hwU);
            this.hwU = abq.hwU;
            this.hym = abq.hym;
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1164;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
