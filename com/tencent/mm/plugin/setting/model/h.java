package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.auv;
import com.tencent.mm.protocal.c.auw;

public final class h extends l implements k {
    private final String bPS;
    private e diJ;
    public final String mOL;
    public final int mOM;
    private final int scene;

    public h(String str, String str2, int i, int i2) {
        this.bPS = str;
        this.mOL = str2;
        this.mOM = i;
        this.scene = i2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        auw auw = (auw) ((b) qVar).dIE.dIL;
        this.diJ.a(i2, auw.rvs.bMH, auw.rvs.bMI, this);
    }

    public final int getType() {
        return 1144;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        a aVar = new a();
        auv auv = new auv();
        auv.bPS = this.bPS;
        auv.rXM = this.mOL;
        auv.rXN = this.mOM;
        aVar.dIG = auv;
        aVar.uri = "/cgi-bin/mmbiz-bin/moduserauth";
        aVar.dIH = new auw();
        aVar.dIF = 1144;
        aVar.dII = 0;
        aVar.dIJ = 0;
        return a(eVar, aVar.KT(), this);
    }
}
