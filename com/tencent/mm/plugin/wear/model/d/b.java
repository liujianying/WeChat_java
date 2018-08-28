package com.tencent.mm.plugin.wear.model.d;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.bd;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.cfa;
import com.tencent.mm.protocal.c.cfb;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends l implements k {
    private com.tencent.mm.ab.b dZf;
    private e diJ;

    public b(String str) {
        a aVar = new a();
        aVar.uri = "/cgi-bin/micromsg-bin/sendyo";
        aVar.dIG = new cfa();
        aVar.dIH = new cfb();
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.dZf = aVar.KT();
        cfa cfa = (cfa) this.dZf.dID.dIL;
        cfa.jTu = str;
        cfa.rWU = cfa.lOH;
        cfa.lOH = (int) bd.iD(str);
        cfa.hcE = 63;
        cfa.szG = 1;
        cfa.hbF = 1;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Wear.NetSceneSendYo", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 976;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dZf, this);
    }
}
