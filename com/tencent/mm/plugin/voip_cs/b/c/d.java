package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bzk;
import com.tencent.mm.protocal.c.bzl;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends l implements k {
    public b diG;
    private e diJ;

    public d(long j, long j2) {
        a aVar = new a();
        aVar.dIG = new bzk();
        aVar.dIH = new bzl();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipredirect";
        aVar.dIF = 285;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bzk bzk = (bzk) this.diG.dID.dIL;
        bzk.svs = j;
        bzk.rxH = j2;
        bzk.see = System.currentTimeMillis();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneVoipCSRedirect", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 285;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
