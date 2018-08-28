package com.tencent.mm.modelsimple;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ahf;
import com.tencent.mm.protocal.c.ahg;

public final class n extends l implements k {
    public final b dZf;
    private e diJ;

    public n() {
        a aVar = new a();
        aVar.dIG = new ahf();
        aVar.dIH = new ahg();
        aVar.uri = "/cgi-bin/micromsg-bin/getremind";
        this.dZf = aVar.KT();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dZf, this);
    }

    public final int getType() {
        return 866;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.diJ.a(i2, i3, str, this);
    }
}
