package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.uw;
import com.tencent.mm.protocal.c.ux;

public final class e extends l implements k {
    public final b dZf;
    private com.tencent.mm.ab.e diJ;
    public boolean qma;

    public e(String str, String str2, boolean z) {
        this.qma = z;
        a aVar = new a();
        uw uwVar = new uw();
        ux uxVar = new ux();
        aVar.dIG = uwVar;
        aVar.dIH = uxVar;
        aVar.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmok";
        aVar.dIF = 972;
        aVar.dII = 0;
        aVar.dIJ = 0;
        uwVar.rya = str;
        uwVar.ryl = str2;
        uwVar.ryn = z;
        this.dZf = aVar.KT();
    }

    public final int getType() {
        return 972;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dZf, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.diJ.a(i2, i3, str, this);
    }
}
