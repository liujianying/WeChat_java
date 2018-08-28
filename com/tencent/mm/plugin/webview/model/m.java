package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c$a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c$b;
import com.tencent.mm.protocal.c.aod;
import com.tencent.mm.protocal.c.aoe;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends l implements k, c$b {
    private final b diG;
    private e doG;
    public c$a pRl;
    public String pRm;
    private final int pRn;
    public String url;

    public m(c$a c_a, String str, String str2, String str3, String str4, String str5, String str6, String str7, byte[] bArr, int i, String str8, int i2) {
        x.i("MicroMsg.webview.NetSceneJSAPIAuth", "NetSceneJSAPIAuth doScene appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s], [%s]", new Object[]{str2, str3, str4, str5, str6, str7, Integer.valueOf(i), str8});
        this.pRl = c_a;
        this.pRm = str3;
        this.url = str;
        this.pRn = i2;
        a aVar = new a();
        aVar.dIG = new aod();
        aVar.dIH = new aoe();
        aVar.uri = "/cgi-bin/mmbiz-bin/jsapi-auth";
        aVar.dIF = 1095;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        aod aod = (aod) this.diG.dID.dIL;
        aod.url = str;
        aod.jPc = str2;
        aod.rQC = str3;
        aod.bJT = str4;
        aod.rQE = str5;
        aod.signature = str6;
        aod.rQF = str7;
        aod.rQG = com.tencent.mm.bk.b.bi(bArr);
        aod.rQH = i;
        aod.scope = str8;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.webview.NetSceneJSAPIAuth", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.doG.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1095;
    }

    public final aod bTY() {
        if (this.diG == null) {
            return null;
        }
        return (aod) this.diG.dID.dIL;
    }

    public final aoe bTZ() {
        if (this.diG == null) {
            return null;
        }
        return (aoe) this.diG.dIE.dIL;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.webview.NetSceneJSAPIAuth", "doScene");
        this.doG = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int bUa() {
        return this.pRn;
    }
}
