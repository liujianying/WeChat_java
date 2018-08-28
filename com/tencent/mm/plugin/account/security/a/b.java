package com.tencent.mm.plugin.account.security.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ahl;
import com.tencent.mm.protocal.c.ahm;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends l implements k {
    private com.tencent.mm.ab.b diG;
    private e diJ;
    public ahm eOo;

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (!(i2 == 0 && i3 == 0)) {
            x.e("MicroMsg.NetSceneGetSafetyInfo", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        this.eOo = (ahm) ((com.tencent.mm.ab.b) qVar).dIE.dIL;
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 850;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        a aVar = new a();
        aVar.dIG = new ahl();
        aVar.dIH = new ahm();
        aVar.uri = "/cgi-bin/micromsg-bin/getsafetyinfo";
        aVar.dIF = 850;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
