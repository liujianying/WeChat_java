package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ajz;
import com.tencent.mm.protocal.c.aka;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends l implements k {
    private b diG = null;
    private e diJ;
    private ajz krp = null;
    public aka krq = null;
    public boolean krr = true;

    public f(String str, String str2) {
        if (bi.oW(str2)) {
            this.krr = true;
            str2 = "";
        } else {
            this.krr = false;
        }
        a aVar = new a();
        aVar.dIG = new ajz();
        aVar.dIH = new aka();
        aVar.dIF = 929;
        aVar.uri = "/cgi-bin/micromsg-bin/getwcoproductlist";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.krp = (ajz) this.diG.dID.dIL;
        this.krp.rMy = str;
        this.krp.rMz = str2;
        x.i("MicroMsg.NetSceneIPCallGetProductList", "NetSceneIPCallGetProductList");
    }

    public final int getType() {
        return 929;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallGetProductList", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.krq = (aka) ((b) qVar).dIE.dIL;
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
