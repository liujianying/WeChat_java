package com.tencent.mm.plugin.label.b;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.rb;
import com.tencent.mm.protocal.c.rc;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends l implements k {
    private final com.tencent.mm.ab.b diG;
    private e diJ;
    public String kAF = null;

    public b(String str) {
        a aVar = new a();
        aVar.dIG = new rb();
        aVar.dIH = new rc();
        aVar.uri = "/cgi-bin/micromsg-bin/delcontactlabel";
        aVar.dIF = 636;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.kAF = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.Label.NetSceneDelContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 636;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        rb rbVar = (rb) this.diG.dID.dIL;
        rbVar.rvl = this.kAF;
        if (this.kAF == null || bi.oW(this.kAF)) {
            x.e("MicroMsg.Label.NetSceneDelContactLabel", "cpan[doScene] label id list is null.");
            eVar2.a(3, -1, "[doScene]empty label is list.", this);
            return 0;
        }
        rbVar.rvl = this.kAF;
        rbVar.rvl = this.kAF;
        return a(eVar, this.diG, this);
    }
}
