package com.tencent.mm.modelsimple;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ty;
import com.tencent.mm.protocal.c.tz;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends l implements k {
    private final b diG;
    private e diJ;

    public g(String str, int i, String str2) {
        x.i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", new Object[]{str, Integer.valueOf(i), str2});
        a aVar = new a();
        aVar.dIG = new ty();
        aVar.dIH = new tz();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/entertempsession";
        aVar.dIF = 1066;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        String str3 = "";
        if (str2 == null) {
            str2 = str3;
        } else if (str2.length() > 32 && i != 19) {
            str2 = str2.substring(0, 32);
        }
        ty tyVar = (ty) this.diG.dID.dIL;
        tyVar.riA = str;
        tyVar.rdq = i;
        tyVar.rxL = com.tencent.mm.bk.b.Uw(str2);
        tyVar.rvr = com.tencent.mm.bk.b.bi(new byte[0]);
        x.i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(tyVar.rvr.lR.length)});
    }

    public final int getType() {
        return 1066;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneEnterTempSession", "onGYNetEnd: %d, %d, %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.diJ.a(i2, i3, str, this);
    }
}
