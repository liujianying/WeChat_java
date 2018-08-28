package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.abd;
import com.tencent.mm.protocal.c.abe;

public final class x extends l implements k {
    private final b diG;
    private e diJ;
    private String hxf = "";

    public x() {
        a aVar = new a();
        aVar.dIG = new abd();
        aVar.dIH = new abe();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardconfiginfo";
        aVar.dIF = 692;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final int getType() {
        return 692;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneGetCardConfigInfo", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            this.hxf = ((abe) this.diG.dIE.dIL).hwU;
            g.Ei().DT().set(282885, this.hxf);
        }
        this.diJ.a(i2, i3, str, this);
    }
}
