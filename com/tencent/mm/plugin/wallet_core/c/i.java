package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.afd;
import com.tencent.mm.protocal.c.afe;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends l implements k {
    private e diJ;
    private b eAN;
    private boolean pjf;
    private afd pjj;
    public afe pjk;

    public i(String str, boolean z) {
        this.pjf = z;
        a aVar = new a();
        aVar.dIG = new afd();
        aVar.dIH = new afe();
        if (z) {
            aVar.dIF = 2803;
            aVar.uri = "/cgi-bin/mmpay-bin/mktgetf2flottery";
        } else {
            aVar.dIF = 2508;
            aVar.uri = "/cgi-bin/mmpay-bin/mktgetlottery";
        }
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.eAN = aVar.KT();
        this.pjj = (afd) this.eAN.dID.dIL;
        this.pjj.rJm = str;
        x.i("MicroMsg.NetSceneMktGetLottery", "NetSceneMktGetLottery, getLotteryParams: %s, isF2f: %s", new Object[]{str, Boolean.valueOf(z)});
    }

    public final int getType() {
        if (this.pjf) {
            return 2803;
        }
        return 2508;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneMktGetLottery", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.pjk = (afe) ((b) qVar).dIE.dIL;
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
