package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ajv;
import com.tencent.mm.protocal.c.ajw;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends l implements k {
    private b diG = null;
    private e diJ;
    private ajv krl = null;
    public ajw krm = null;

    public d() {
        a aVar = new a();
        aVar.dIG = new ajv();
        aVar.dIH = new ajw();
        aVar.dIF = 288;
        aVar.uri = "/cgi-bin/micromsg-bin/getwcogiftcardlist";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.krl = (ajv) this.diG.dID.dIL;
        x.i("MicroMsg.NetSceneIPCallGetGiftCardList", "NetSceneIPCallGetGiftCardList");
    }

    public final int getType() {
        return 288;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallGetGiftCardList", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.krm = (ajw) ((b) qVar).dIE.dIL;
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
