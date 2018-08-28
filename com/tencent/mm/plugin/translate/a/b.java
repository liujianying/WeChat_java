package com.tencent.mm.plugin.translate.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aio;
import com.tencent.mm.protocal.c.aip;
import com.tencent.mm.protocal.c.bub;
import com.tencent.mm.protocal.c.buc;
import java.util.LinkedList;

public final class b extends l implements k {
    private final com.tencent.mm.ab.b diG;
    private e diJ = null;
    public LinkedList<buc> oEq;

    public b(LinkedList<bub> linkedList) {
        a aVar = new a();
        aVar.dIG = new aio();
        aVar.dIH = new aip();
        aVar.uri = "/cgi-bin/micromsg-bin/gettranstext";
        aVar.dIF = 631;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        aio aio = (aio) this.diG.dID.dIL;
        aio.rLq = linkedList;
        aio.hbE = linkedList.size();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 631;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        aip aip = (aip) this.diG.dIE.dIL;
        this.diJ.a(i2, i3, str, this);
        this.oEq = aip.rLq;
    }
}
