package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.lm;
import com.tencent.mm.protocal.c.ln;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends l implements k {
    private e diJ;
    private b eAN;
    public ln hUj;

    public j() {
        a aVar = new a();
        aVar.dIG = new lm();
        aVar.dIH = new ln();
        aVar.dIF = 1256;
        aVar.uri = "/cgi-bin/mmpay-bin/f2fannounce";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.eAN = aVar.KT();
        x.d("MicroMsg.NetSceneF2fAnnouce", "do cgi");
    }

    public final int getType() {
        return 1256;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneF2fAnnouce", "errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.hUj = (ln) ((b) qVar).dIE.dIL;
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
