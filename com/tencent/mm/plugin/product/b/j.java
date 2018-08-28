package com.tencent.mm.plugin.product.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.au;
import com.tencent.mm.protocal.c.bbm;
import com.tencent.mm.protocal.c.bbn;
import com.tencent.mm.protocal.c.bie;
import com.tencent.mm.protocal.c.um;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class j extends l implements k {
    private b diG;
    private e diJ;
    public String lQN;
    public LinkedList<um> lQY;
    public LinkedList<au> lQZ;

    public j(LinkedList<bie> linkedList, int i) {
        int i2 = 0;
        a aVar = new a();
        aVar.dIG = new bbm();
        aVar.dIH = new bbn();
        aVar.uri = "/cgi-bin/micromsg-bin/presubmitorder";
        aVar.dIF = 554;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bbm bbm = (bbm) this.diG.dID.dIL;
        bbm.rmL = linkedList;
        if (linkedList != null) {
            i2 = linkedList.size();
        }
        bbm.lOS = i2;
        bbm.sdG = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        bbn bbn = (bbn) ((b) qVar).dIE.dIL;
        if (i2 == 0 && i3 == 0 && bbn.rmN == 0) {
            x.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.ExpressCount " + bbn.rIK);
            x.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.LockId " + bbn.rmM);
            this.lQY = bbn.sdH;
            this.lQN = bbn.rmM;
            this.lQZ = bbn.sdI;
        }
        if (i3 == 0 && bbn.rmN != 0) {
            i3 = bbn.rmN;
            str = bbn.rmO;
        }
        x.d("MicroMsg.NetSceneMallPreSubmitOrder", "errCode " + i3 + ", errMsg " + str);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 554;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
