package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.uu;
import com.tencent.mm.protocal.c.uv;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends l implements k {
    final b dZf;
    private e diJ;

    public d(String str) {
        a aVar = new a();
        uu uuVar = new uu();
        uv uvVar = new uv();
        aVar.dIG = uuVar;
        aVar.dIH = uvVar;
        aVar.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmget";
        aVar.dIF = 971;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.dZf = aVar.KT();
        uuVar.rya = str;
        x.d("MicroMsg.NetSceneExtDeviceLoginConfirmGet", "[oneliang][NetSceneExtDeviceLoginConfirmGet]loginUrl:%s", new Object[]{str});
    }

    public final int getType() {
        return 971;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dZf, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneExtDeviceLoginConfirmGet", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " errMsg:" + str);
        this.diJ.a(i2, i3, str, this);
    }
}
