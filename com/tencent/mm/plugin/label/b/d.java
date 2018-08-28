package com.tencent.mm.plugin.label.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.auz;
import com.tencent.mm.protocal.c.ava;
import com.tencent.mm.protocal.c.bxe;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class d extends l implements k {
    private final b diG;
    private e diJ;
    private LinkedList<bxe> kAG = new LinkedList();

    public d(LinkedList<bxe> linkedList) {
        a aVar = new a();
        aVar.dIG = new auz();
        aVar.dIH = new ava();
        aVar.uri = "/cgi-bin/micromsg-bin/modifycontactlabellist";
        aVar.dIF = 638;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.kAG = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 638;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[doScene].");
        this.diJ = eVar2;
        auz auz = (auz) this.diG.dID.dIL;
        auz.rYe = this.kAG;
        auz.rGU = this.kAG.size();
        return a(eVar, this.diG, this);
    }
}
