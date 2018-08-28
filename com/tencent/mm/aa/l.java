package com.tencent.mm.aa;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ano;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.gc;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class l extends com.tencent.mm.ab.l implements k {
    LinkedList<bhz> dHV = null;
    LinkedList<ano> dHW = null;
    private e diJ;

    public l(LinkedList<bhz> linkedList) {
        this.dHV = linkedList;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (this.dHV == null || this.dHV.size() <= 0) {
            x.e("MicroMsg.NetSceneBatchGetHeadImg", g.Ac() + "doScene ReqSize==0");
            return -1;
        }
        this.diJ = eVar2;
        a aVar = new a();
        aVar.dIG = new gc();
        aVar.dIH = new gd();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetheadimg";
        aVar.dIF = 123;
        aVar.dII = 15;
        aVar.dIJ = 1000000015;
        q KT = aVar.KT();
        gc gcVar = (gc) KT.dID.dIL;
        gcVar.rgF = this.dHV;
        gcVar.hbF = this.dHV.size();
        return a(eVar, KT, this);
    }

    protected final int a(q qVar) {
        return b.dJm;
    }

    protected final int Cc() {
        return 20;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneBatchGetHeadImg", "errType:" + i2 + " errCode:" + i3);
        this.dHW = ((gd) ((b) qVar).dIE.dIL).rgI;
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 123;
    }
}
