package com.tencent.mm.modelstat;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.adk;
import com.tencent.mm.protocal.c.adl;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends l implements k {
    private e doG;
    final b ejL;

    public j(com.tencent.mm.bk.b bVar) {
        a aVar = new a();
        adk adk = new adk();
        adk.qZv = 0;
        adk.rHQ = bVar;
        aVar.dIG = adk;
        aVar.dIH = new adl();
        aVar.uri = "/cgi-bin/mmbiz-bin/geteventsampleconf";
        aVar.dIF = 1126;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.ejL = aVar.KT();
    }

    public final int getType() {
        return 1126;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneUpdateEventConfig", "start update event config");
        this.dJc = true;
        this.doG = eVar2;
        return a(eVar, this.ejL, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneUpdateEventConfig", "onGYNetEnd errType: %d, errCode: %d, errMsg %s, IReqResp %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, qVar.toString()});
        this.doG.a(i2, i3, str, this);
    }
}
