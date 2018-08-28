package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bzp;
import com.tencent.mm.protocal.c.bzq;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends l implements k {
    public b diG;
    private e diJ;

    public f(long j, long j2, int i) {
        a aVar = new a();
        aVar.dIG = new bzp();
        aVar.dIH = new bzq();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipsync";
        aVar.dIF = 818;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bzp bzp = (bzp) this.diG.dID.dIL;
        bzp.svs = j;
        bzp.rxH = j2;
        bzp.svC = i;
        bzp.see = System.currentTimeMillis();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneVoipCSSync", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 818;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
