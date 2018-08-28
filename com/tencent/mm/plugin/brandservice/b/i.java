package com.tencent.mm.plugin.brandservice.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bjl;
import com.tencent.mm.protocal.c.bjm;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends l implements k {
    private String bHt;
    private e diJ;
    private b hnO;
    private long hnQ;
    public bjm hnR;
    private int scene;

    public i(String str, long j, int i) {
        this.bHt = str;
        this.hnQ = j;
        this.scene = i;
        x.i("MicroMsg.NetSceneSearchHomePageNew", "Constructors: keyword (%s) , businessType (%d), scene (%d)", new Object[]{str, Long.valueOf(j), Integer.valueOf(i)});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSearchHomePageNew", "netId (%d) , errType (%d) , errCode (%d) , errMsg (%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0 && this.hnO != null) {
            this.hnR = (bjm) this.hnO.dIE.dIL;
        }
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1070;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneSearchHomePageNew", "doScene");
        this.diJ = eVar2;
        if (bi.oW(this.bHt)) {
            x.e("MicroMsg.NetSceneSearchHomePageNew", "keyword is unavailable");
            return -1;
        }
        a aVar = new a();
        aVar.dIF = 1070;
        aVar.uri = "/cgi-bin/mmbiz-bin/bizsearch/homepage";
        aVar.dIG = new bjl();
        aVar.dIH = new bjm();
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.hnO = aVar.KT();
        bjl bjl = (bjl) this.hnO.dID.dIL;
        bjl.rHk = this.bHt;
        bjl.rUI = b.JU();
        bjl.rll = this.hnQ;
        bjl.sjq = this.scene;
        x.i("MicroMsg.NetSceneSearchHomePageNew", "businessTypeList is %d", new Object[]{Long.valueOf(this.hnQ)});
        return a(eVar, this.hnO, this);
    }
}
