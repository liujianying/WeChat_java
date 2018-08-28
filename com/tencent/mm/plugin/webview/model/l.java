package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aoi;
import com.tencent.mm.protocal.c.aoj;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends com.tencent.mm.ab.l implements k {
    public final b diG;
    private e doG;

    public l(String str, String str2) {
        a aVar = new a();
        aVar.dIG = new aoi();
        aVar.dIH = new aoj();
        aVar.uri = "/cgi-bin/mmpay-bin/payibggetuseropenid";
        aVar.dIF = 1566;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        aoi aoi = (aoi) this.diG.dID.dIL;
        aoi.hbL = str2;
        aoi.jQb = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetUserOpenId", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.doG.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1566;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneGetUserOpenId", "doScene");
        this.doG = eVar2;
        return a(eVar, this.diG, this);
    }
}
