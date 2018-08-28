package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bsn;
import com.tencent.mm.protocal.c.bso;
import com.tencent.mm.protocal.c.bsp;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class g extends l implements k {
    private final b diG;
    private e diJ;

    public g(LinkedList<bsn> linkedList, int i) {
        a aVar = new a();
        aVar.dIG = new bso();
        aVar.dIH = new bsp();
        aVar.uri = "/cgi-bin/micromsg-bin/talkstatreport";
        aVar.dIF = 373;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bso bso = (bso) this.diG.dID.dIL;
        bso.spU = linkedList.size();
        bso.spV = linkedList;
        bso.otY = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneTalkStatReport", "doScene");
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 373;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneTalkStatReport", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.diJ.a(i2, i3, str, this);
        } else {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
