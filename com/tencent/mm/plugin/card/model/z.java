package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.abh;
import com.tencent.mm.protocal.c.abi;
import com.tencent.mm.sdk.platformtools.x;

public final class z extends l implements k {
    private final b diG;
    private e diJ;
    public CardGiftInfo hwX;

    public z(int i, String str) {
        a aVar = new a();
        aVar.dIG = new abh();
        aVar.dIH = new abi();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardgiftinfo";
        aVar.dIF = 1165;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        abh abh = (abh) this.diG.dID.dIL;
        abh.qZT = i;
        abh.qZU = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetCardGiftInfo", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.hwX = CardGiftInfo.a((abi) this.diG.dIE.dIL);
            x.d("MicroMsg.NetSceneGetCardGiftInfo", "%s", new Object[]{this.hwX.toString()});
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1165;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
