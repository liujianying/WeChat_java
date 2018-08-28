package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aaz;
import com.tencent.mm.protocal.c.aba;
import com.tencent.mm.sdk.platformtools.x;

public final class o extends l implements k {
    b diG = null;
    private e diJ = null;

    public o() {
        a aVar = new a();
        aVar.dIG = new aaz();
        aVar.dIH = new aba();
        aVar.uri = "/cgi-bin/micromsg-bin/getboundharddevices";
        aVar.dIF = 539;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((aaz) this.diG.dID.dIL).hcD = 1;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetSceneGetBoundHardDevices", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 539;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
