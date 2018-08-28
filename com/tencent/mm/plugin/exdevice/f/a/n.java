package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bvb;
import com.tencent.mm.protocal.c.bvc;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends l implements k {
    private b diG = null;
    private e diJ = null;
    public int iyb;
    public int iyc;
    public int opType;

    public n(int i, int i2) {
        this.opType = i;
        this.iyb = i2;
        a aVar = new a();
        aVar.dIG = new bvb();
        aVar.dIH = new bvc();
        aVar.uri = "/cgi-bin/mmbiz-bin/rank/updateranksetting";
        aVar.dIF = 1044;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bvb bvb = (bvb) this.diG.dID.dIL;
        bvb.bYt = this.opType;
        bvb.bWA = this.iyb;
    }

    public final int getType() {
        return 1044;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneUpdateRankSetting", "hy: scene end. errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.iyc = ((bvc) this.diG.dIE.dIL).bWA;
        }
        this.diJ.a(i2, i3, str, this);
    }
}
