package com.tencent.mm.ac;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.blq;
import com.tencent.mm.protocal.c.blr;
import com.tencent.mm.protocal.c.ia;
import com.tencent.mm.sdk.platformtools.x;

public final class y extends l implements k {
    Object data;
    public b diG;
    private e diJ;

    public y(ia iaVar, Object obj) {
        a aVar = new a();
        aVar.dIG = new blq();
        aVar.dIH = new blr();
        aVar.uri = "/cgi-bin/mmocbiz-bin/setbizenterpriseattr";
        aVar.dIF = 1228;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        blq blq = (blq) this.diG.dID.dIL;
        blq.rFY = iaVar;
        blq.mask = 1;
        blq.rFW = 1;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1228;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        x.i("MicroMsg.NetSceneSetBizEnterpriseAttr", "do scene");
        return a(eVar, this.diG, this);
    }
}
