package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c$a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c$b;
import com.tencent.mm.protocal.c.aol;
import com.tencent.mm.protocal.c.aom;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class n extends l implements k, c$b {
    public final b diG;
    private e doG;
    public String gsE;
    public c$a pRl;
    private final int pRn;

    public n(c$a c_a, String str, String str2, LinkedList<String> linkedList, String str3, String str4, String str5, String str6, int i, String str7, int i2) {
        x.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "NetSceneJSAPIPreVerify doScene url[%s], appid[%s], [%s], [%s], [%s], [%s]", new Object[]{str, str2, str3, str4, str5, str6});
        this.pRl = c_a;
        this.gsE = str;
        this.pRn = i2;
        a aVar = new a();
        aVar.dIG = new aol();
        aVar.dIH = new aom();
        aVar.uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
        aVar.dIF = 1093;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        aol aol = (aol) this.diG.dID.dIL;
        aol.url = str;
        aol.bPS = str2;
        aol.rQU = linkedList;
        aol.bJT = str3;
        aol.rQE = str4;
        aol.signature = str5;
        aol.rQF = str6;
        aol.scene = i;
        aol.rQV = str7;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.doG.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1093;
    }

    public final aom bUb() {
        if (this.diG == null) {
            return null;
        }
        return (aom) this.diG.dIE.dIL;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "doScene");
        this.doG = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int bUa() {
        return this.pRn;
    }
}
