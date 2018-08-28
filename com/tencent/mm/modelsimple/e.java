package com.tencent.mm.modelsimple;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.protocal.c.rq;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends l implements k {
    private final b diG;
    private com.tencent.mm.ab.e diJ;

    public e(String str) {
        x.i("MicroMsg.NetSceneDelTempSession", "NetSceneDelTempSession %s", new Object[]{str});
        a aVar = new a();
        aVar.dIG = new rp();
        aVar.dIH = new rq();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/deltempsession";
        aVar.dIF = 1067;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        rp rpVar = (rp) this.diG.dID.dIL;
        rpVar.riA = str;
        rpVar.rvr = com.tencent.mm.bk.b.bi(new byte[0]);
    }

    public final int getType() {
        return 1067;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneDelTempSession", "onGYNetEnd: %d, %d, %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.diJ.a(i2, i3, str, this);
    }
}
