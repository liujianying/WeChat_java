package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.arx;
import com.tencent.mm.protocal.c.ary;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends l implements k {
    String appId;
    final b diG;
    private e doG;
    String fnN;

    public g(String str, String str2) {
        this.appId = str;
        this.fnN = str2;
        a aVar = new a();
        aVar.dIG = new arx();
        aVar.dIH = new ary();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_downloadcdninfo";
        aVar.dIF = 1035;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        arx arx = (arx) this.diG.dID.dIL;
        arx.bPS = str;
        arx.rUv = str2;
        x.i("MicroMsg.NetSceneDownloadCdnInfo", "download cdn info, appid : %s, mediaId : %s", new Object[]{str, str2});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneDownloadCdnInfo", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.doG.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1035;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.doG = eVar2;
        return a(eVar, this.diG, this);
    }
}
