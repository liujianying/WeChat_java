package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.rr;
import com.tencent.mm.protocal.c.rs;

public final class c extends l implements k {
    public final String appId;
    private e diJ;
    private final int scene;

    public c(String str, int i) {
        this.appId = str;
        this.scene = i;
    }

    public final int getType() {
        return 1127;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        a aVar = new a();
        rr rrVar = new rr();
        rrVar.bPS = this.appId;
        rrVar.cae = this.scene;
        aVar.dIG = rrVar;
        aVar.uri = "/cgi-bin/mmbiz-bin/deluserauth";
        aVar.dIH = new rs();
        aVar.dIF = 1127;
        aVar.dII = 0;
        aVar.dIJ = 0;
        return a(eVar, aVar.KT(), this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        rs rsVar = (rs) ((b) qVar).dIE.dIL;
        this.diJ.a(i2, rsVar.rvs.bMH, rsVar.rvs.bMI, this);
    }
}
