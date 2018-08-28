package com.tencent.mm.plugin.account.security.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.rl;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends l implements k {
    private String byN;
    private b diG;
    private e diJ;

    public a(String str) {
        this.byN = str;
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new rl();
        aVar.dIH = new rm();
        aVar.uri = "/cgi-bin/micromsg-bin/delsafedevice";
        aVar.dIF = 362;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((rl) this.diG.dID.dIL).rvq = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneDelSafeDevice", "NetSceneDelSafeDevice, errType= " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            rm rmVar = (rm) this.diG.dIE.dIL;
            g.Ei().DT().set(64, Integer.valueOf(rmVar.raE));
            x.d("MicroMsg.NetSceneDelSafeDevice", "NetSceneDelSafeDevice, get safedevice state = " + rmVar.raE);
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 362;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (bi.oW(this.byN)) {
            x.e("MicroMsg.NetSceneDelSafeDevice", "null device id");
            return -1;
        }
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
