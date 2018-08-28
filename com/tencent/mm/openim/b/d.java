package com.tencent.mm.openim.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.protocal.c.axy;
import com.tencent.mm.protocal.c.axz;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends l implements k {
    private final b diG;
    private e diJ;
    public h.b euu;
    private int opType;

    public d(h.b bVar) {
        a aVar = new a();
        aVar.dIG = new axy();
        aVar.dIH = new axz();
        aVar.uri = "/cgi-bin/micromsg-bin/openimoplog";
        aVar.dIF = 806;
        this.diG = aVar.KT();
        this.opType = bVar.lcD;
        this.euu = bVar;
        x.i("MicroMsg.NetSceneOpenIMOPLog", "type: %d", new Object[]{Integer.valueOf(this.opType)});
        axy axy = (axy) this.diG.dID.dIL;
        axy.type = this.opType;
        axy.saV = new com.tencent.mm.bk.b(bVar.getBuffer());
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 806;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneOpenIMOPLog", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, opType:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(this.opType)});
        this.diJ.a(i2, i3, str, this);
    }
}
