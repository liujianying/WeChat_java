package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ajt;
import com.tencent.mm.protocal.c.aju;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends l implements k {
    private b diG = null;
    private e diJ = null;
    private ajt krj = null;
    public aju krk = null;

    public c() {
        a aVar = new a();
        aVar.dIG = new ajt();
        aVar.dIH = new aju();
        aVar.dIF = 746;
        aVar.uri = "/cgi-bin/micromsg-bin/getwcocallinfo";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.krj = (ajt) this.diG.dID.dIL;
        x.i("MicroMsg.NetSceneIPCallGetCallInfo", "NetSceneIPCallGetCallInfo");
    }

    public final int getType() {
        return 746;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallGetCallInfo", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.krk = (aju) ((b) qVar).dIE.dIL;
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
