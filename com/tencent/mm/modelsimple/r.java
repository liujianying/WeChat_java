package com.tencent.mm.modelsimple;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdu;
import com.tencent.mm.protocal.c.bdv;

public final class r extends l implements k {
    private b diG;
    private e diJ;
    public int efX = 1;
    public int efY;

    public r(int i) {
        a aVar = new a();
        aVar.dIG = new bdu();
        aVar.dIH = new bdv();
        aVar.uri = "/cgi-bin/micromsg-bin/queryhaspasswd";
        aVar.dIF = 255;
        aVar.dII = 132;
        aVar.dIJ = 1000000132;
        this.diG = aVar.KT();
        ((bdu) this.diG.dID.dIL).otY = i;
        this.efY = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 255;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.diJ.a(i2, i3, str, this);
    }
}
