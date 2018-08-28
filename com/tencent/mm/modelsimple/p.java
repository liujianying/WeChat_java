package com.tencent.mm.modelsimple;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.arl;
import com.tencent.mm.protocal.c.arm;
import com.tencent.mm.sdk.platformtools.x;

public final class p extends l implements k {
    public final b diG;
    private e diJ;

    public p() {
        a aVar = new a();
        aVar.dIG = new arl();
        aVar.dIH = new arm();
        aVar.uri = "/cgi-bin/micromsg-bin/logout";
        aVar.dIF = 282;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((arl) this.diG.dID.dIL).otY = 0;
    }

    public final int getType() {
        return 282;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneLogout", "doScene");
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (!(i2 == 0 && i3 == 0)) {
            x.d("MicroMsg.NetSceneLogout", "logout Error. ");
        }
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
