package com.tencent.mm.plugin.label.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aqf;
import com.tencent.mm.protocal.c.buv;
import com.tencent.mm.protocal.c.buw;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends l implements k {
    private final b diG;
    private com.tencent.mm.ab.e diJ;
    private aqf kAH = null;

    public e(int i, String str) {
        a aVar = new a();
        aVar.dIG = new buv();
        aVar.dIH = new buw();
        aVar.uri = "/cgi-bin/micromsg-bin/updatecontactlabel";
        aVar.dIF = 637;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        if (i >= 0 && !bi.oW(str)) {
            this.kAH = new aqf();
            this.kAH.rSH = i;
            this.kAH.rSG = str;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.Label.NetSceneUpdateContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 637;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        buv buv = (buv) this.diG.dID.dIL;
        if (this.kAH != null) {
            buv.srS = this.kAH;
            return a(eVar, this.diG, this);
        }
        x.e("MicroMsg.Label.NetSceneUpdateContactLabel", "cpan[doScene] label pair is null.");
        eVar2.a(3, -1, "[doScene]empty label pair.", this);
        return 0;
    }
}
