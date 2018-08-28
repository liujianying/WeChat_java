package com.tencent.mm.ac;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.apq;
import com.tencent.mm.protocal.c.apr;
import com.tencent.mm.sdk.platformtools.x;

public final class u extends l implements k {
    public String dMD;
    public b diG;
    private e diJ;

    public u(String str, String str2) {
        a aVar = new a();
        aVar.dIG = new apq();
        aVar.dIH = new apr();
        aVar.uri = "/cgi-bin/mmkf-bin/kfgetbindlist";
        aVar.dIF = 674;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        apq apq = (apq) this.diG.dID.dIL;
        apq.rSp = str;
        apq.rSq = str2;
        this.dMD = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneKFGetBindList", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 674;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        x.i("MicroMsg.NetSceneKFGetBindList", "do scene");
        return a(eVar, this.diG, this);
    }

    public final apr MT() {
        if (this.diG == null || this.diG.dIE.dIL == null) {
            return null;
        }
        return (apr) this.diG.dIE.dIL;
    }
}
