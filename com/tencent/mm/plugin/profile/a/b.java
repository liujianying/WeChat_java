package com.tencent.mm.plugin.profile.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bls;
import com.tencent.mm.protocal.c.blt;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends l implements k {
    public com.tencent.mm.ab.b diG;
    private e diJ;

    public b(String str, int i) {
        a aVar = new a();
        aVar.dIG = new bls();
        aVar.dIH = new blt();
        aVar.uri = "/cgi-bin/mmocbiz-bin/setbrandflag";
        aVar.dIF = 1363;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bls bls = (bls) this.diG.dID.dIL;
        bls.riK = str;
        bls.skw = i;
        bls.skx = 4;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneSetBrandFlag", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1363;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        x.i("MicroMsg.brandservice.NetSceneSetBrandFlag", "do scene");
        return a(eVar, this.diG, this);
    }
}
