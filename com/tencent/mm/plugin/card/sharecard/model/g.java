package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bmt;
import com.tencent.mm.protocal.c.bmu;
import com.tencent.mm.protocal.c.bmv;
import com.tencent.mm.protocal.c.bnk;
import com.tencent.mm.protocal.c.bqs;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class g extends l implements k {
    private final b diG;
    private e diJ;
    public String hwU;
    public int hwV;
    public String hwW;

    public g(int i, LinkedList<bmv> linkedList, String str, String str2, bnk bnk, int i2, bqs bqs) {
        a aVar = new a();
        aVar.dIG = new bmt();
        aVar.dIH = new bmu();
        aVar.uri = "/cgi-bin/micromsg-bin/sharecarditem";
        aVar.dIF = 902;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bmt bmt = (bmt) this.diG.dID.dIL;
        bmt.skX = i;
        bmt.dzs = linkedList;
        bmt.skY = str;
        bmt.rGk = str2;
        x.i("MicroMsg.NetSceneShareCardItem", "list length is " + linkedList.size());
        bmt.skZ = bnk;
        bmt.cae = i2;
        bmt.qZR = bqs;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneShareCardItem", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(902), Integer.valueOf(i2), Integer.valueOf(i3)});
        bmu bmu;
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.NetSceneShareCardItem", "do ShareCardItem netscene success!");
            bmu = (bmu) this.diG.dIE.dIL;
            if (bmu != null) {
                this.hwU = bmu.hwU;
                this.hwV = bmu.hwV;
                this.hwW = bmu.hwW;
            }
        } else {
            bmu = (bmu) this.diG.dIE.dIL;
            if (bmu != null) {
                this.hwU = bmu.hwU;
                this.hwV = bmu.hwV;
                this.hwW = bmu.hwW;
            }
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 902;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
