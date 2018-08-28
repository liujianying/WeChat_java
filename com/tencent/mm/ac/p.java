package com.tencent.mm.ac;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.hp;
import com.tencent.mm.protocal.c.hq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class p extends l implements k {
    private String cYO;
    private a<p> dMC;
    b diG;
    private e diJ;

    public p(String str, String str2, a<p> aVar) {
        this(str, str2);
        this.dMC = aVar;
    }

    private p(String str, String str2) {
        this.cYO = str;
        x.i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] NetSceneBizAttrSync (%s)", new Object[]{str});
        a aVar = new a();
        aVar.dIF = 1075;
        aVar.uri = "/cgi-bin/mmbiz-bin/bizattr/bizattrsync";
        aVar.dIG = new hp();
        aVar.dIH = new hq();
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        hp hpVar = (hp) this.diG.dID.dIL;
        hpVar.riA = this.cYO;
        hpVar.riB = new com.tencent.mm.bk.b(bi.WP(bi.oV(str2)));
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
        if (this.dMC != null) {
            this.dMC.b(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1075;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
