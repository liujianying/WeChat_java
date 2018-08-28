package com.tencent.mm.modelappbrand;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aho;
import com.tencent.mm.protocal.c.ahp;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends l implements k {
    public final b dFA;
    private e doG;

    public n(int i) {
        a aVar = new a();
        aVar.dIG = new aho();
        aVar.dIH = new ahp();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getservicenotifyoptions";
        this.dFA = aVar.KT();
        ((aho) this.dFA.dID.dIL).rKO = i;
    }

    public final ahp JR() {
        return (ahp) this.dFA.dIE.dIL;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.doG != null) {
            this.doG.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1145;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
        this.doG = eVar2;
        return a(eVar, this.dFA, this);
    }
}
