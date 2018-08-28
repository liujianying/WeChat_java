package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bd;
import com.tencent.mm.protocal.c.be;
import com.tencent.mm.protocal.c.bj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class l extends com.tencent.mm.ab.l implements k {
    private b diG;
    public e diJ;
    private LinkedList<bj> nnP;

    public l(LinkedList<bj> linkedList) {
        a aVar = new a();
        aVar.dIG = new bd();
        aVar.dIH = new be();
        aVar.uri = "/cgi-bin/mmoc-bin/ad/addatareport";
        aVar.dIF = 1295;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((bd) this.diG.dID.dIL).rbu = linkedList;
        this.nnP = linkedList;
    }

    public final int getType() {
        return 1295;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSnsAdDataReport", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.diJ.a(i2, i3, str, this);
    }
}
