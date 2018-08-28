package com.tencent.mm.plugin.product.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bie;
import com.tencent.mm.protocal.c.ko;
import com.tencent.mm.protocal.c.kp;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class f extends l implements k {
    private b diG;
    private e diJ;

    public f(LinkedList<bie> linkedList, String str) {
        int i = 0;
        a aVar = new a();
        aVar.dIG = new ko();
        aVar.dIH = new kp();
        aVar.uri = "/cgi-bin/micromsg-bin/cancelpreorder";
        aVar.dIF = 555;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ko koVar = (ko) this.diG.dID.dIL;
        koVar.rmL = linkedList;
        if (linkedList != null) {
            i = linkedList.size();
        }
        koVar.lOS = i;
        koVar.rmM = str;
        x.d("MicroMsg.NetSceneMallCancelPreOrder", "lockId " + str);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        kp kpVar = (kp) ((b) qVar).dIE.dIL;
        if (i3 == 0 && kpVar.rmN != 0) {
            i3 = kpVar.rmN;
            str = kpVar.rmO;
        }
        x.d("MicroMsg.NetSceneMallCancelPreOrder", "errCode " + i3 + ", errMsg " + str);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 555;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
