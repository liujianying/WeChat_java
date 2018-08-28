package com.tencent.mm.plugin.nfc_open.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.qh;
import com.tencent.mm.protocal.c.qi;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends l implements k {
    public com.tencent.mm.ab.b diG;
    private e diJ;

    public b(int i) {
        a aVar = new a();
        aVar.dIG = new qh();
        aVar.dIH = new qi();
        aVar.uri = "/cgi-bin/mmpay-bin/cpucardgetconfig2";
        aVar.dIF = 1561;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((qh) this.diG.dID.dIL).version = i;
    }

    public final int getType() {
        return 1561;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneCpuCardGetConfig", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.diJ.a(i2, i3, str, this);
    }
}
