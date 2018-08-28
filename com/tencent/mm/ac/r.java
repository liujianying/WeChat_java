package com.tencent.mm.ac;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bcs;
import com.tencent.mm.protocal.c.bct;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Date;

public final class r extends l implements k {
    private Object data;
    public b diG;
    private e diJ;

    public r(b bVar, int i, int i2, Object obj) {
        a aVar = new a();
        aVar.dIG = new bcs();
        aVar.dIH = new bct();
        aVar.uri = "/cgi-bin/mmocbiz-bin/reportpluginstat";
        aVar.dIF = 2805;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bcs bcs = (bcs) this.diG.dID.dIL;
        bcs.seR = 1;
        bcs.seS = bVar.field_wwCorpId;
        bcs.riY = bVar.field_wwUserVid;
        g.Eg();
        bcs.seT = com.tencent.mm.kernel.a.Df();
        bcs.scene = i2;
        bcs.bIH = i;
        bcs.seU = 0;
        bcs.seV = new Date().getTime();
        bcs.seW = 1;
        bcs.scj = com.tencent.mm.sdk.platformtools.e.aj(null, d.qVN);
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneEnterprisePushStat", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 2805;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        x.i("MicroMsg.NetSceneEnterprisePushStat", "do scene");
        return a(eVar, this.diG, this);
    }
}
