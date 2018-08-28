package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ss;
import com.tencent.mm.protocal.c.st;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends l implements k {
    private e diJ;
    private b eAN;
    private ss pjd;
    public st pje;
    private boolean pjf;

    public g(String str, int i, boolean z) {
        this.pjf = z;
        a aVar = new a();
        aVar.dIG = new ss();
        aVar.dIH = new st();
        if (z) {
            aVar.dIF = 1859;
            aVar.uri = "/cgi-bin/mmpay-bin/mktdrawf2flottery";
        } else {
            aVar.dIF = 2547;
            aVar.uri = "/cgi-bin/mmpay-bin/mktdrawlottery";
        }
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.eAN = aVar.KT();
        this.pjd = (ss) this.eAN.dID.dIL;
        this.pjd.rvZ = str;
        this.pjd.rwa = i;
        x.i("MicroMsg.NetSceneMktDrawLottery", "NetSceneMktDrawLottery, drawLotteryParams: %s, drawLotteryType: %s, isF2f: %s", new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)});
    }

    public final int getType() {
        if (this.pjf) {
            return 1859;
        }
        return 2547;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneMktDrawLottery", "onGYNetEnd netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.pje = (st) ((b) qVar).dIE.dIL;
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
