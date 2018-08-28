package com.tencent.mm.ac;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aar;
import com.tencent.mm.protocal.c.aas;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class s extends l implements k {
    Object data;
    public b diG;
    private e diJ;

    public s(String str, int i, Object obj) {
        a aVar = new a();
        aVar.dIG = new aar();
        aVar.dIH = new aas();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizenterpriseattr";
        aVar.dIF = 1343;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        aar aar = (aar) this.diG.dID.dIL;
        aar.riK = str;
        aar.rFW = i;
        aar.rFX = w.chP().equals("zh_CN") ? 2 : 1;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1343;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        x.i("MicroMsg.NetSceneGetBizEnterpriseAttr", "do scene");
        return a(eVar, this.diG, this);
    }
}
