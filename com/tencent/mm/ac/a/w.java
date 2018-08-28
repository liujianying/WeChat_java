package com.tencent.mm.ac.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.but;
import com.tencent.mm.protocal.c.buu;
import com.tencent.mm.protocal.c.hs;
import com.tencent.mm.sdk.platformtools.x;

public final class w extends l implements k {
    Object data;
    public b diG;
    private e diJ;

    public w(String str, hs hsVar, Object obj) {
        a aVar = new a();
        aVar.dIG = new but();
        aVar.dIH = new buu();
        aVar.uri = "/cgi-bin/mmocbiz-bin/updatebizchat";
        aVar.dIF = 1356;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        but but = (but) this.diG.dID.dIL;
        but.riK = str;
        but.rDx = hsVar;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneUpdateBizChat", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1356;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        x.i("MicroMsg.brandservice.NetSceneUpdateBizChat", "do scene");
        return a(eVar, this.diG, this);
    }
}
