package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.b;
import com.tencent.mm.protocal.c.aoc;
import com.tencent.mm.protocal.c.aop;
import com.tencent.mm.protocal.c.aoq;
import com.tencent.mm.protocal.c.apd;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class p extends l implements k, b {
    public final com.tencent.mm.ab.b diG;
    private e doG;
    private final int pRn;
    public aoc pRo;

    public p(aoc aoc, String str, String str2, String str3, String str4, String str5, String str6, String str7, com.tencent.mm.bk.b bVar, int i, LinkedList<apd> linkedList, int i2) {
        x.i("MicroMsg.webview.NetSceneJSAPISetAuth", "NetSceneJSAPISetAuth doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s]", new Object[]{str, str2, str3, str4, str5, str6, str7, Integer.valueOf(i)});
        this.pRo = aoc;
        this.pRn = i2;
        a aVar = new a();
        aVar.dIG = new aop();
        aVar.dIH = new aoq();
        aVar.uri = "/cgi-bin/mmbiz-bin/jsapi-setauth";
        aVar.dIF = 1096;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        aop aop = (aop) this.diG.dID.dIL;
        aop.url = str;
        aop.bPS = str2;
        aop.rQC = str3;
        aop.bJT = str4;
        aop.rQE = str5;
        aop.signature = str6;
        aop.rQF = str7;
        aop.rQH = i;
        aop.rQG = bVar;
        aop.rQL = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.webview.NetSceneJSAPISetAuth", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.doG.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1096;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.webview.NetSceneJSAPISetAuth", "doScene");
        this.doG = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int bUa() {
        return this.pRn;
    }
}
