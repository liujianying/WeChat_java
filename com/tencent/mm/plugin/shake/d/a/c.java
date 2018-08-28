package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.axf;
import com.tencent.mm.protocal.c.axg;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends l implements k {
    private b diG;
    private e diJ;

    public c(int i, String str) {
        a aVar = new a();
        aVar.dIG = new axf();
        aVar.dIH = new axg();
        aVar.uri = "/cgi-bin/mmoctv/optvhist";
        aVar.dIF = 1740;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        axf axf = (axf) this.diG.dID.dIL;
        axf.jRb = i;
        axf.sap = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneOpTvHist", "onGYNetEnd [%d,%d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1740;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
