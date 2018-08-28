package com.tencent.mm.ao;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bcq;
import com.tencent.mm.protocal.c.bcr;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends l implements k {
    private b diG;
    private e diJ;
    boolean ebi = false;
    int ebj = 0;

    public a(int i, String str) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new bcq();
        aVar.dIH = new bcr();
        aVar.uri = "/cgi-bin/micromsg-bin/pushnewtips";
        aVar.dIF = 597;
        this.diG = aVar.KT();
        bcq bcq = (bcq) this.diG.dID.dIL;
        bcq.seO = i;
        bcq.seP = 1;
        bcq.riD = str;
        this.ebj = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            this.ebi = ((bcr) ((b) qVar).dIE.dIL).seQ;
            this.diJ.a(i2, i3, str, this);
            return;
        }
        x.e("MicroMsg.NetScenePushNewTips", "errType:" + i2 + " errCode:" + i3);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 597;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetScenePushNewTips", "doScene");
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
