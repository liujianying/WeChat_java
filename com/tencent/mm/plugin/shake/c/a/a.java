package com.tencent.mm.plugin.shake.c.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ks;
import com.tencent.mm.protocal.c.kt;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends l implements k {
    private final b diG;
    private e diJ;

    public a(String str, String str2) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new ks();
        aVar.dIH = new kt();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/cancelshakecard";
        aVar.dIF = 1252;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ks ksVar = (ks) this.diG.dID.dIL;
        ksVar.huU = str;
        ksVar.cad = str2;
    }

    public final int getType() {
        return 1252;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneCancelShakeCard", "onGYNetEnd, getType = 1252 errType = " + i2 + " errCode = " + i3);
        this.diJ.a(i2, i3, str, this);
    }
}
