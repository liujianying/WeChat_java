package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.brw;
import com.tencent.mm.protocal.c.brx;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends l implements k {
    private final b diG;
    private e diJ;
    public int mStatus;
    public int oFh;

    public i(int i) {
        a aVar = new a();
        aVar.dIG = new brw();
        aVar.dIH = new brx();
        aVar.uri = "/cgi-bin/micromsg-bin/switchopvoiceprint";
        aVar.dIF = 615;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((brw) this.diG.dID.dIL).bOh = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 615;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSwitchOpVoicePrint", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        brx brx = (brx) ((b) qVar).dIE.dIL;
        if (i2 == 0 || i3 == 0) {
            this.mStatus = brx.sdf;
            this.oFh = brx.spF;
            this.diJ.a(i2, i3, str, this);
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }
}
