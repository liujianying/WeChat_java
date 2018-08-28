package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.b;
import com.tencent.mm.protocal.c.aon;
import com.tencent.mm.protocal.c.aoo;
import com.tencent.mm.sdk.platformtools.x;

public final class o extends l implements k, b {
    private final com.tencent.mm.ab.b diG;
    private e doG;
    public a pRl;
    private final int pRn;

    public o(a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, byte[] bArr, int i) {
        x.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "NetSceneJSAPIRealtimeVerify doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s]", new Object[]{str, str2, str3, str4, str5, str6, str7});
        this.pRl = aVar;
        this.pRn = i;
        com.tencent.mm.ab.b.a aVar2 = new com.tencent.mm.ab.b.a();
        aVar2.dIG = new aon();
        aVar2.dIH = new aoo();
        aVar2.uri = "/cgi-bin/mmbiz-bin/jsapi-realtimeverify";
        aVar2.dIF = 1094;
        aVar2.dII = 0;
        aVar2.dIJ = 0;
        this.diG = aVar2.KT();
        aon aon = (aon) this.diG.dID.dIL;
        aon.url = str;
        aon.bPS = str2;
        aon.rQC = str3;
        aon.bJT = str4;
        aon.rQE = str5;
        aon.signature = str6;
        aon.rQF = str7;
        aon.rQG = com.tencent.mm.bk.b.bi(bArr);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.doG.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1094;
    }

    public final aoo bUc() {
        if (this.diG == null) {
            return null;
        }
        return (aoo) this.diG.dIE.dIL;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "doScene");
        this.doG = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int bUa() {
        return this.pRn;
    }
}
