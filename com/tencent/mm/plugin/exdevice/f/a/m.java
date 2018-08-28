package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.buz;
import com.tencent.mm.protocal.c.bva;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends l implements k {
    private b diG = null;
    private e diJ = null;
    public String ixw;
    public String ixx;

    public m(String str, String str2) {
        this.ixw = str;
        this.ixx = str2;
        a aVar = new a();
        aVar.dIG = new buz();
        aVar.dIH = new bva();
        aVar.uri = "/cgi-bin/mmbiz-bin/rank/updatecover";
        aVar.dIF = 1040;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        buz buz = (buz) this.diG.dID.dIL;
        buz.rLQ = str;
        buz.ixx = str2;
    }

    public final int getType() {
        return 1040;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneUpdateRankCoverAndMotto", "hy: scene end. errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.diJ.a(i2, i3, str, this);
    }
}
