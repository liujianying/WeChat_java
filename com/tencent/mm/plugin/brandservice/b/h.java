package com.tencent.mm.plugin.brandservice.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bjb;
import com.tencent.mm.protocal.c.bjc;
import com.tencent.mm.protocal.c.ju;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends l implements k {
    private String bHt;
    private e diJ;
    private String fuu;
    private b hnO;
    private bjc hnP;
    private long hnQ;
    private int offset;
    private int scene;

    public h(String str, long j, int i, int i2, String str2) {
        this.bHt = str;
        this.hnQ = j;
        this.offset = i;
        this.scene = i2;
        this.fuu = str2;
        x.i("MicroMsg.NetSceneSearchDetailPageNew", "Constructors: keyword = (%s) , LSB exist () , businessType is (%d) , offset is (%d) , scene is (%d), searchId(%s).", new Object[]{str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str2});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSearchDetailPageNew", "netId (%d) , errType (%d) , errCode (%d) , errMsg (%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0 && this.hnO != null) {
            this.hnP = (bjc) this.hnO.dIE.dIL;
        }
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1071;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        if (bi.oW(this.bHt)) {
            x.e("MicroMsg.NetSceneSearchDetailPageNew", "keyword is unavailable.");
            return -1;
        }
        a aVar = new a();
        aVar.dIF = 1071;
        aVar.uri = "/cgi-bin/mmbiz-bin/bizsearch/detailpage";
        aVar.dIG = new bjb();
        aVar.dIH = new bjc();
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.hnO = aVar.KT();
        bjb bjb = (bjb) this.hnO.dID.dIL;
        bjb.rUI = b.JU();
        bjb.rHk = this.bHt;
        bjb.rll = this.hnQ;
        bjb.rjC = this.offset;
        bjb.sjq = this.scene;
        bjb.rlo = this.fuu;
        return a(eVar, this.hnO, this);
    }

    public final ju auP() {
        return this.hnP == null ? null : this.hnP.sjs;
    }
}
