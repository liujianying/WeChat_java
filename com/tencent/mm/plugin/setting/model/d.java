package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ym;
import com.tencent.mm.protocal.c.yn;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends l implements k {
    private b diG;
    private e diJ;

    public d(String str) {
        a aVar = new a();
        aVar.dIG = new ym();
        aVar.dIH = new yn();
        aVar.uri = "/cgi-bin/micromsg-bin/generalset";
        aVar.dIF = 177;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ym ymVar = (ym) this.diG.dID.dIL;
        ymVar.rwJ = 1;
        ymVar.rEm = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneGeneralSet", "doScene");
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 177;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGeneralSet", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        this.diJ.a(i2, i3, str, this);
    }
}
