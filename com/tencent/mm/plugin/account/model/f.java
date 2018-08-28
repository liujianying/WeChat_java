package com.tencent.mm.plugin.account.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bks;
import com.tencent.mm.protocal.c.bkt;

public final class f extends l implements k {
    private final b diG;
    private e diJ = null;

    public f(bks bks) {
        a aVar = new a();
        aVar.dIG = bks;
        aVar.dIH = new bkt();
        aVar.uri = "/cgi-bin/micromsg-bin/sendphoto2fbwall";
        aVar.dIF = 433;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 433;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.diJ.a(i2, i3, str, this);
    }
}
