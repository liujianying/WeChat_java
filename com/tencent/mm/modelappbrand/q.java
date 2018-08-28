package com.tencent.mm.modelappbrand;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.chv;
import com.tencent.mm.protocal.c.chw;
import com.tencent.mm.sdk.platformtools.x;

public final class q extends l implements k {
    private final b dFA;
    private e doG;

    public q(String str) {
        a aVar = new a();
        aVar.dIG = new chv();
        aVar.dIH = new chw();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/wxatmplcomplaint";
        aVar.dIF = 1198;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.dFA = aVar.KT();
        ((chv) this.dFA.dID.dIL).sBR = str;
    }

    public final chw JV() {
        if (this.dFA != null) {
            return (chw) this.dFA.dIE.dIL;
        }
        return null;
    }

    public final int getType() {
        return 1198;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.doG != null) {
            this.doG.a(i2, i3, str, this);
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
        this.doG = eVar2;
        return a(eVar, this.dFA, this);
    }
}
