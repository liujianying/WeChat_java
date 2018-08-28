package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bis;
import com.tencent.mm.protocal.c.bit;

public final class u extends l implements k {
    public final b diG;
    private e doG;

    public u(String str, String str2, String str3, String str4, String str5) {
        a aVar = new a();
        aVar.dIG = new bis();
        aVar.dIH = new bit();
        aVar.uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize";
        aVar.dIF = 1388;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bis bis = (bis) this.diG.dID.dIL;
        bis.bPS = str;
        bis.scope = str2;
        bis.state = str3;
        bis.sjg = str4;
        bis.sjh = str5;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.doG.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1388;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.doG = eVar2;
        return a(eVar, this.diG, this);
    }
}
