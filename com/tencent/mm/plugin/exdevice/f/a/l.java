package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ara;
import com.tencent.mm.protocal.c.arb;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends com.tencent.mm.ab.l implements k {
    public int bYt;
    private b diG = null;
    private e diJ = null;
    public String dxK;
    public String ixK;

    public l(String str, String str2, int i, String str3) {
        this.ixK = str3;
        this.dxK = str2;
        this.bYt = i;
        this.ixK = str3;
        a aVar = new a();
        aVar.dIG = new ara();
        aVar.dIH = new arb();
        aVar.uri = "/cgi-bin/mmbiz-bin/rank/addlike";
        aVar.dIF = 1041;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ara ara = (ara) this.diG.dID.dIL;
        ara.iEL = str2;
        ara.username = str;
        ara.bYt = i;
        ara.dxc = str3;
    }

    public final int getType() {
        return 1041;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneUpdateLikeStatus", "hy: end. errType: %d, errCode: %d, errMsg: %s, ", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.diJ.a(i2, i3, str, this);
    }
}
