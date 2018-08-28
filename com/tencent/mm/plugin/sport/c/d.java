package com.tencent.mm.plugin.sport.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sport.b.c;
import com.tencent.mm.protocal.c.aia;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends l implements k {
    private b dZf;
    private e diJ;
    aia ooU;
    aib ooV;
    c ooW;

    public d(long j, long j2, c cVar) {
        this.ooW = cVar;
        a aVar = new a();
        aVar.dIF = 1734;
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/getsteplist";
        aVar.dIG = new aia();
        aVar.dIH = new aib();
        this.dZf = aVar.KT();
        this.ooU = (aia) this.dZf.dID.dIL;
        this.ooU.rvI = (int) (j / 1000);
        this.ooU.rvJ = (int) (j2 / 1000);
    }

    public final int getType() {
        return 1734;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dZf, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Sport.NetSceneGetStepList", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.ooV = (aib) this.dZf.dIE.dIL;
        this.diJ.a(i2, i3, str, this);
    }
}
