package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bzd;
import com.tencent.mm.protocal.c.bze;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends l implements k {
    public b diG;
    private e diJ;

    public a(int i, long j, long j2, String str, int i2) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new bzd();
        aVar.dIH = new bze();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoiphangup";
        aVar.dIF = 880;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bzd bzd = (bzd) this.diG.dID.dIL;
        bzd.sef = i;
        bzd.svs = j;
        bzd.rxH = j2;
        bzd.svt = str;
        bzd.rEv = i2;
        bzd.see = System.currentTimeMillis();
    }

    public final int getType() {
        return 880;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneVoipCSHangUp", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.diJ.a(i2, i3, str, this);
    }
}
