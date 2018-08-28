package com.tencent.mm.plugin.appbrand.j;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aoz;
import com.tencent.mm.protocal.c.apa;
import com.tencent.mm.protocal.c.chf;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends l implements k {
    public final b diG;
    private e doG;
    private a<c> gkA;

    public c(String str, String str2, String str3, int i, int i2, int i3, a<c> aVar) {
        this(str, str2, str3, i, i2, i3);
        this.gkA = aVar;
    }

    private c(String str, String str2, String str3, int i, int i2, int i3) {
        x.i("MicroMsg.webview.NetSceneJSOperateWxData", "NetSceneJSLogin doScene appId [%s], data [%s], grantScope [%s], versionType [%d], opt [%d], extScene [%d]", new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        a aVar = new a();
        aVar.dIG = new aoz();
        aVar.dIH = new apa();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-operatewxdata";
        aVar.dIF = 1133;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        aoz aoz = (aoz) this.diG.dID.dIL;
        aoz.jQb = str;
        aoz.hbs = new com.tencent.mm.bk.b(str2.getBytes() == null ? new byte[0] : str2.getBytes());
        aoz.rRj = str3;
        aoz.rRb = i;
        aoz.rRa = i2;
        if (i3 > 0) {
            aoz.rRc = new chf();
            aoz.rRc.scene = i3;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.webview.NetSceneJSOperateWxData", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.doG != null) {
            this.doG.a(i2, i3, str, this);
        }
        if (this.gkA != null) {
            this.gkA.b(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1133;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.webview.NetSceneJSOperateWxData", "doScene");
        this.doG = eVar2;
        return a(eVar, this.diG, this);
    }
}
