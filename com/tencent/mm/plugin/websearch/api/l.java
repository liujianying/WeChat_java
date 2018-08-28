package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.cfl;
import com.tencent.mm.protocal.c.cfm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends com.tencent.mm.ab.l implements k {
    private b dZf;
    private e diJ;
    cfl pLk = new cfl();
    cfm pLl;

    public l(int i) {
        a aVar = new a();
        aVar.dIF = 1948;
        aVar.uri = "/cgi-bin/mmsearch-bin/websearchconfig";
        aVar.dIG = new cfl();
        aVar.dIH = new cfm();
        this.dZf = aVar.KT();
        this.pLk = (cfl) this.dZf.dID.dIL;
        this.pLk.rUH = p.zP(0);
        this.pLk.iwP = w.fD(ad.getContext());
        this.pLk.rEx = p.bjC();
        this.pLk.rUI = p.JU();
        this.pLk.otY = i;
        this.pLk.rll = 0;
    }

    public final int getType() {
        return 1948;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dZf, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.WebSearch.NetSceneWebSearchConfig", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.pLl = (cfm) this.dZf.dIE.dIL;
            if (this.pLl != null) {
                x.v("MicroMsg.WebSearch.NetSceneWebSearchConfig", "return data\n%s", new Object[]{this.pLl.rjK});
            }
            this.diJ.a(i2, i3, str, this);
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }
}
