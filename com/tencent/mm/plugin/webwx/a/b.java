package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.uo;
import com.tencent.mm.protocal.c.up;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends l implements k {
    public int bNI;
    private final com.tencent.mm.ab.b dZf;
    private e diJ;

    public b(int i) {
        this.bNI = i;
        a aVar = new a();
        uo uoVar = new uo();
        up upVar = new up();
        aVar.dIG = uoVar;
        aVar.dIH = upVar;
        aVar.uri = "/cgi-bin/micromsg-bin/extdevicecontrol";
        aVar.dIF = 792;
        aVar.dII = 0;
        aVar.dIJ = 0;
        uoVar.jRb = i;
        uoVar.rxZ = 1;
        this.dZf = aVar.KT();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneExtDeviceControl", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " errMsg:" + str);
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 792;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dZf, this);
    }
}
