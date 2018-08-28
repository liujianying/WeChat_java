package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.zl;
import com.tencent.mm.protocal.c.zm;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends l implements k {
    private e diJ;
    public final b ivx;

    public h(String str, String str2) {
        a aVar = new a();
        aVar.dIG = new zl();
        aVar.dIH = new zm();
        aVar.uri = "/cgi-bin/mmbiz-bin/getappticket";
        aVar.dIF = 1097;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.ivx = aVar.KT();
        zl zlVar = (zl) this.ivx.dID.dIL;
        zlVar.bPS = str;
        zlVar.signature = str2;
    }

    public final int getType() {
        return 1097;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.ivx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetAppTicket", "errType = " + i2 + ", errCode = " + i3);
        this.diJ.a(i2, i3, str, this);
    }
}
