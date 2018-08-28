package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.q;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.aax;
import com.tencent.mm.protocal.c.aay;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends l implements k {
    private final b diG;
    private e diJ;

    public d() {
        a aVar = new a();
        aVar.dIG = new aax();
        aVar.dIH = new aay();
        aVar.uri = "/cgi-bin/micromsg-bin/getbottlecount";
        aVar.dIF = 152;
        aVar.dII = 49;
        aVar.dIJ = 1000000049;
        aVar.dIK = false;
        this.diG = aVar.KT();
        aax aax = (aax) this.diG.dID.dIL;
        aax.hbL = q.GF();
        aax.rGb = (int) bi.VE();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 152;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        aay aay = (aay) this.diG.dIE.dIL;
        if (i2 == 0 && i3 == 0) {
            c.nh(aay.rGd);
            c.ng(aay.rGc);
        } else if (aay.rfn == -2002 || aay.rfn == -56) {
            c.nh(0);
            c.ng(0);
        }
        x.d("MicroMsg.NetSceneGetBottleCount", "onGYNetEnd type:" + i2 + " code:" + i3 + " ret:" + aay.rfn + " pickCnt:" + aay.rGd + " throwCnt:" + aay.rGc);
        this.diJ.a(0, aay.rfn, str, this);
    }
}
