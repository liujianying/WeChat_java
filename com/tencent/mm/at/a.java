package com.tencent.mm.at;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends l implements k {
    private final b diG;
    private e diJ;

    public a(String str) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new rv();
        aVar.dIH = new rw();
        aVar.uri = "/cgi-bin/micromsg-bin/deletecardimg";
        aVar.dIF = 576;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((rv) this.diG.dID.dIL).rvx = str;
    }

    public final int getType() {
        return 576;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneDeleteCardImg", "onGYNetEnd:%s, %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.diJ.a(i2, i3, str, this);
    }
}
