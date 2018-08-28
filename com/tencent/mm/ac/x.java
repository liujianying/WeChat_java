package com.tencent.mm.ac;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bgl;
import com.tencent.mm.protocal.c.bgm;
import com.tencent.mm.protocal.c.bgn;
import java.util.LinkedList;

public final class x extends l implements k {
    private b diG;
    private e diJ;

    public x(LinkedList<bgl> linkedList) {
        a aVar = new a();
        aVar.dIG = new bgm();
        aVar.dIH = new bgn();
        aVar.uri = "/cgi-bin/micromsg-bin/reportcommand";
        aVar.dIF = 2592;
        aVar.dII = 176;
        aVar.dIJ = 1000000176;
        this.diG = aVar.KT();
        ((bgm) this.diG.dID.dIL).rtB = linkedList;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneReportBrandSession", "reportcommand MsgReport size %d", new Object[]{Integer.valueOf(r0.rtB.size())});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 2592;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
