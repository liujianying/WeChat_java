package com.tencent.mm.plugin.websearch.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.protocal.c.bjn;
import com.tencent.mm.protocal.c.bjo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends l implements k {
    public b diG;
    private e diJ;

    public a(String str) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIF = 1944;
        aVar.uri = "/cgi-bin/mmsearch-bin/searchlocalpage";
        aVar.dIG = new bjn();
        aVar.dIH = new bjo();
        this.diG = aVar.KT();
        bjn bjn = (bjn) this.diG.dID.dIL;
        bjn.sjx = str;
        bjn.otY = 25;
        bjn.iwP = w.fD(ad.getContext());
        bjn.rUI = p.JU();
    }

    public final int getType() {
        return this.diG.dIF;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.FTS.NetSceneWebSearchLocalPage", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
