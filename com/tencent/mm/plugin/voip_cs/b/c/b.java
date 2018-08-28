package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bzf;
import com.tencent.mm.protocal.c.bzg;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends l implements k {
    private com.tencent.mm.ab.b diG;
    private e diJ;

    public b(long j, long j2) {
        a aVar = new a();
        aVar.dIG = new bzf();
        aVar.dIH = new bzg();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipheartbeat";
        aVar.dIF = 795;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bzf bzf = (bzf) this.diG.dID.dIL;
        bzf.svs = j;
        bzf.rxH = j2;
        bzf.see = System.currentTimeMillis();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneVoipCSHeartBeat", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 795;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
