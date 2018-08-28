package com.tencent.mm.plugin.account.bind.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.he;
import com.tencent.mm.protocal.c.hf;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends l implements k {
    private final b diG;
    private e diJ;

    public a(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new he();
        aVar.dIH = new hf();
        aVar.uri = "/cgi-bin/micromsg-bin/bindlinkedincontact";
        aVar.dIF = 549;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        he heVar = (he) this.diG.dID.dIL;
        heVar.rfe = 1;
        heVar.rhm = i;
        heVar.rhn = str;
        heVar.rho = str2;
        heVar.rhp = str3;
        heVar.rhq = str4;
        heVar.rhr = str5;
        heVar.rhs = str6;
        heVar.rht = str7;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 549;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneBindLinkedinContact", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        he heVar = (he) this.diG.dID.dIL;
        if (i2 == 0 && i3 == 0) {
            g.Ei().DT().set(286722, heVar.rho);
            g.Ei().DT().set(286721, heVar.rhn);
            g.Ei().DT().set(286723, heVar.rhp);
        }
        this.diJ.a(i2, i3, str, this);
    }
}
