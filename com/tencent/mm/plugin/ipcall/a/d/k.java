package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bce;
import com.tencent.mm.protocal.c.bcf;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends l implements com.tencent.mm.network.k {
    private b diG = null;
    private e diJ = null;
    public bce krA = null;
    public bcf krB = null;

    public k(int i, long j, long j2) {
        a aVar = new a();
        aVar.dIG = new bce();
        aVar.dIH = new bcf();
        aVar.dIF = 726;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnredirect";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.krA = (bce) this.diG.dID.dIL;
        this.krA.rxG = i;
        this.krA.rxH = j;
        this.krA.seh = j2;
    }

    public final int getType() {
        return 726;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallRedirect", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.krB = (bcf) ((b) qVar).dIE.dIL;
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
