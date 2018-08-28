package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.vb;
import com.tencent.mm.protocal.c.vc;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends l implements k {
    private e diJ;
    private b eAN;
    private vb kMZ;
    private vc kNa;

    public a(String str) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new vb();
        aVar.dIH = new vc();
        aVar.dIF = 1987;
        aVar.dII = 0;
        aVar.dIJ = 0;
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/ffclearwxhb";
        this.eAN = aVar.KT();
        this.kMZ = (vb) this.eAN.dID.dIL;
        this.kMZ.kLZ = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.kNa = (vc) ((b) qVar).dIE.dIL;
        x.i("NetSceneF2FLuckyMoneyClear", "errType %d,errCode %d,errMsg %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(this.kNa.hUm), this.kNa.hUn});
        if (this.diJ != null) {
            this.diJ.a(i2, this.kNa.hUm, this.kNa.hUn, this);
        }
    }

    public final int getType() {
        return 1987;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }
}
