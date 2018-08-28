package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bgx;
import com.tencent.mm.protocal.c.bgy;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends l implements k {
    private b dZf;
    private e diJ;
    private String pLo;
    private int scene;

    public n(bgx bgx) {
        a aVar = new a();
        aVar.dIF = 1134;
        aVar.uri = "/cgi-bin/mmsearch-bin/searchreport";
        aVar.dIG = bgx;
        aVar.dIH = new bgy();
        this.dZf = aVar.KT();
        this.scene = bgx.otY;
        this.pLo = bgx.shQ;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.FTS.NetSceneWebSearchReport", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.diJ.a(i2, i3, str, this);
            ad.Ad(6);
            ad.a(this.scene, 5, i2, i3, this.pLo);
            return;
        }
        this.diJ.a(i2, i3, str, this);
        ad.Ad(7);
    }

    public final int getType() {
        return 1134;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.FTS.NetSceneWebSearchReport", "doScene %d", new Object[]{Integer.valueOf(this.scene)});
        ad.Ad(5);
        ad.r(this.scene, 4, this.pLo);
        this.diJ = eVar2;
        return a(eVar, this.dZf, this);
    }
}
