package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.arw;
import com.tencent.mm.protocal.c.asb;
import com.tencent.mm.protocal.c.asc;

public final class x extends l implements k {
    String appId;
    String bNH;
    final b diG;
    private e doG;

    public x(String str, String str2, arw arw) {
        this.appId = str;
        this.bNH = str2;
        a aVar = new a();
        aVar.dIG = new asb();
        aVar.dIH = new asc();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_uploadcdninfo";
        aVar.dIF = 1034;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        asb asb = (asb) this.diG.dID.dIL;
        asb.bPS = str;
        asb.rUw = arw;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneUploadCdnInfo", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.doG.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1034;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.doG = eVar2;
        return a(eVar, this.diG, this);
    }
}
