package com.tencent.mm.plugin.ext.c.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.nk;
import com.tencent.mm.protocal.c.nl;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends l implements k {
    private b diG;
    public e diJ;
    public int iKY = -1;
    public String mUrl = null;

    public a(String str, int i, int i2) {
        this.mUrl = str;
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new nk();
        aVar.dIH = new nl();
        aVar.uri = "/cgi-bin/micromsg-bin/checkcamerascan";
        aVar.dIF = 782;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        x.i("MicroMsg.NetSceneCheckUrlAvailableInWx", "hy: checking url: %s", new Object[]{str});
        nk nkVar = (nk) this.diG.dID.dIL;
        nkVar.URL = this.mUrl;
        nkVar.rrv = i;
        nkVar.rrw = i2;
    }

    public final int getType() {
        return 782;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneCheckUrlAvailableInWx", "hy: on get camera url end. errType; %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        nl nlVar = (nl) ((b) qVar).dIE.dIL;
        if (i2 == 0 && i3 == 0) {
            this.iKY = nlVar.hcE;
        }
        this.diJ.a(i2, i3, str, this);
    }
}
