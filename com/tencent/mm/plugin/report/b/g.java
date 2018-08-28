package com.tencent.mm.plugin.report.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ag;
import com.tencent.mm.protocal.c.ah;
import com.tencent.mm.protocal.c.ys;
import com.tencent.mm.protocal.c.yt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends l implements k {
    private static boolean bgH = false;
    private static Object lock = new Object();
    private b diG;
    private e diJ;
    private ys mDS = null;
    public ah mDT;

    private static void hs(boolean z) {
        synchronized (lock) {
            bgH = z;
        }
    }

    public g(int i, int i2) {
        hs(true);
        ag agVar = new ag();
        this.mDS = new ys();
        try {
            agVar.qZC = i;
            agVar.qZD = i2;
            this.mDS.rEW = agVar;
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneGetAPMStrategy", "parse data error");
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        try {
            this.mDT = null;
            if (com.tencent.mm.kernel.g.Eh().dpP == null || com.tencent.mm.kernel.g.Eh().dpP.dJs == null) {
                x.f("MicroMsg.NetSceneGetAPMStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
                this.diJ.a(i2, i3, str, this);
            } else if (i2 != 0) {
                x.e("MicroMsg.NetSceneGetAPMStrategy", "get report strategy err, errType:" + i2 + ", errCode:" + i3);
                this.diJ.a(i2, i3, str, this);
                hs(false);
            } else {
                x.d("MicroMsg.NetSceneGetAPMStrategy", "get report strategy ok");
                this.mDT = ((yt) this.diG.dIE.dIL).rEX;
                this.diJ.a(i2, i3, str, this);
                hs(false);
            }
        } finally {
            hs(false);
        }
    }

    public final int getType() {
        return 914;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        com.tencent.mm.kernel.g.Eg();
        if (a.Dw()) {
            b.a aVar = new b.a();
            aVar.dIK = false;
            aVar.dIG = this.mDS;
            aVar.dIH = new yt();
            aVar.uri = "/cgi-bin/micromsg-bin/getapmstrategy";
            aVar.dIF = 914;
            this.diG = aVar.KT();
            int a = a(eVar, this.diG, this);
            if (a >= 0) {
                return a;
            }
            x.i("MicroMsg.NetSceneGetAPMStrategy", "mark all failed. do scene %d", Integer.valueOf(a));
            try {
                this.mDT = null;
                hs(false);
                return a;
            } catch (Throwable e) {
                x.e("MicroMsg.NetSceneGetAPMStrategy", "onStrategyResp failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), bi.i(e));
                return a;
            }
        }
        x.w("MicroMsg.NetSceneGetAPMStrategy", "get mrs strategy must go after login");
        return -1;
    }
}
