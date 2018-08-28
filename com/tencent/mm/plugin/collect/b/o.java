package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bme;
import com.tencent.mm.protocal.c.bmf;
import com.tencent.mm.sdk.platformtools.x;

public final class o extends l implements k {
    private e diJ;
    private b eAN;
    private bme hUD;

    public o(String str) {
        a aVar = new a();
        aVar.dIG = new bme();
        aVar.dIH = new bmf();
        aVar.dIF = 304;
        aVar.uri = "/cgi-bin/micromsg-bin/setpushsound";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.eAN = aVar.KT();
        this.hUD = (bme) this.eAN.dID.dIL;
        this.hUD.hcE = 3;
        this.hUD.skz = str;
        x.i("MicroMsg.NetSceneSetPushSound", "type: %d, sound: %s", new Object[]{Integer.valueOf(3), str});
    }

    public final int getType() {
        return 304;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSetPushSound", "errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
