package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.an;
import com.tencent.mm.protocal.c.ao;
import com.tencent.mm.sdk.platformtools.x;

public final class q extends l implements k {
    private final b diG;
    private e diJ;
    public CardGiftInfo hwX;

    public q(int i, String str, String str2, Boolean bool) {
        a aVar = new a();
        aVar.dIG = new an();
        aVar.dIH = new ao();
        aVar.uri = "/cgi-bin/micromsg-bin/acceptgiftcard";
        aVar.dIF = 1136;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        an anVar = (an) this.diG.dID.dIL;
        anVar.qZT = i;
        anVar.qZU = str;
        anVar.qZV = str2;
        anVar.qZW = bool.booleanValue();
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneAcceptGiftCard", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.hwX = CardGiftInfo.a((ao) this.diG.dIE.dIL);
            x.d("MicroMsg.NetSceneAcceptGiftCard", "%s", new Object[]{this.hwX.toString()});
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1136;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
