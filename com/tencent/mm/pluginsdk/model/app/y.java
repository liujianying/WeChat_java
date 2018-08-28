package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.cu;
import com.tencent.mm.protocal.c.cv;
import com.tencent.mm.sdk.platformtools.x;

public final class y extends l implements k {
    private b diG;
    private e diJ;
    int qAc;
    x qAd;

    public y(int i, x xVar) {
        this.qAc = i;
        a aVar = new a();
        aVar.dIG = new cu();
        aVar.dIH = new cv();
        aVar.uri = "/cgi-bin/micromsg-bin/appcenter";
        aVar.dIF = 452;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        cu cuVar = (cu) this.diG.dID.dIL;
        byte[] cbx = xVar.cbx();
        if (cbx != null) {
            cuVar.rcT = new bhy().bq(cbx);
        }
        cuVar.hcE = i;
        this.qAd = xVar;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneAppCenter", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            this.qAd.bg(ab.a(((cv) this.diG.dIE.dIL).rcU));
            this.qAd.a(i, i2, i3, str, this.diG, bArr);
            this.diJ.a(i2, i3, str, this);
            return;
        }
        x.e("MicroMsg.NetSceneAppCenter", "errType = " + i2 + ", errCode = " + i3);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 452;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
