package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ur;

public final class c extends l implements k {
    private final b dZf;
    private e diJ;

    public c(String str) {
        a aVar = new a();
        uq uqVar = new uq();
        ur urVar = new ur();
        aVar.dIG = uqVar;
        aVar.dIH = urVar;
        aVar.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmcancel";
        aVar.dIF = 973;
        aVar.dII = 0;
        aVar.dIJ = 0;
        uqVar.rya = str;
        this.dZf = aVar.KT();
    }

    public final int getType() {
        return 973;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dZf, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.diJ.a(i2, i3, str, this);
    }
}
