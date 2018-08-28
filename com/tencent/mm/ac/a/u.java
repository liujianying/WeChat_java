package com.tencent.mm.ac.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.beg;
import com.tencent.mm.protocal.c.beh;
import com.tencent.mm.sdk.platformtools.x;

public final class u extends l implements k {
    public b diG;
    private e diJ;

    public u(String str, String str2) {
        a aVar = new a();
        aVar.dIG = new beg();
        aVar.dIH = new beh();
        aVar.uri = "/cgi-bin/mmocbiz-bin/quitbizchat";
        aVar.dIF = 1358;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        beg beg = (beg) this.diG.dID.dIL;
        beg.riK = str;
        beg.riE = str2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneQuitBizChat", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1358;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        x.i("MicroMsg.brandservice.NetSceneQuitBizChat", "do scene");
        return a(eVar, this.diG, this);
    }
}
