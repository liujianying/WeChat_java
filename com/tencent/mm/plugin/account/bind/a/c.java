package com.tencent.mm.plugin.account.bind.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.buh;
import com.tencent.mm.protocal.c.bui;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends l implements k {
    private final b diG;
    private e diJ;

    public c() {
        a aVar = new a();
        aVar.dIG = new buh();
        aVar.dIH = new bui();
        aVar.uri = "/cgi-bin/micromsg-bin/unbindlinkedincontact";
        aVar.dIF = 550;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((buh) this.diG.dID.dIL).rfe = 1;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 550;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneUnBindLinkedinContact", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            g.Ei().DT().set(286722, "");
            g.Ei().DT().set(286721, "");
            g.Ei().DT().set(286723, "");
        }
        this.diJ.a(i2, i3, str, this);
    }
}
