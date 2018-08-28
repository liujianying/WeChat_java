package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.acy;
import com.tencent.mm.protocal.c.acz;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends l implements k {
    public final b diG;
    private e doG;
    public String iiI;
    private String iiJ;

    public j(String str, String str2) {
        a aVar = new a();
        aVar.dIG = new acy();
        aVar.dIH = new acz();
        aVar.uri = "/cgi-bin/micromsg-bin/getemotionactivity";
        aVar.dIF = 368;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.iiI = str;
        this.iiJ = str2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.doG = eVar2;
        acy acy = (acy) this.diG.dID.dIL;
        acy.rHs = this.iiI;
        acy.rwk = this.iiJ;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.emoji.NetSceneGetEmotionActivity", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.doG.a(i2, i3, str, this);
    }

    public final int getType() {
        return 368;
    }
}
