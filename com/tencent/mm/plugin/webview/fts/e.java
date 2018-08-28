package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.protocal.c.aqs;
import com.tencent.mm.protocal.c.cda;
import com.tencent.mm.protocal.c.cdb;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends l implements k {
    public int bWo = -1;
    b diG;
    private com.tencent.mm.ab.e diJ;

    public e() {
        a aVar = new a();
        aVar.dIG = new cda();
        aVar.dIH = new cdb();
        aVar.uri = "/cgi-bin/mmux-bin/wxaapp/weappsearchguide";
        aVar.dIF = 1866;
        this.diG = aVar.KT();
        aqs JU = p.JU();
        cda cda = (cda) this.diG.dID.dIL;
        if (JU != null) {
            cda.syE = (double) JU.rms;
            cda.syF = (double) JU.rmr;
        }
        cda.syG = p.bjC();
    }

    public final int getType() {
        return this.diG.dIF;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneWeAppSearchGuide", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
