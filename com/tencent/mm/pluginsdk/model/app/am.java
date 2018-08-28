package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.yf;
import com.tencent.mm.protocal.c.yg;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class am extends l implements k {
    private b diG;
    private e diJ;
    private int eiF;
    private String jOg;

    public am(int i, String str) {
        a aVar = new a();
        aVar.dIG = new yf();
        aVar.dIH = new yg();
        aVar.uri = "/cgi-bin/micromsg-bin/gamereportkv";
        aVar.dIF = 427;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        yf yfVar = (yf) this.diG.dID.dIL;
        yfVar.rjL = d.qVI;
        yfVar.rjM = d.qVH;
        yfVar.rjN = d.qVK;
        yfVar.rjO = d.qVL;
        yfVar.rjP = w.chP();
        yfVar.mEk = i;
        yfVar.rjQ = str;
        this.eiF = i;
        this.jOg = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MircoMsg.NetsceneGameKVReport", "errType = " + i2 + ", errCode = " + i3 + ", logId = " + this.eiF + ", logExt = " + this.jOg);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 427;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
