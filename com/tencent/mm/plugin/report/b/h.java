package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.a.a.c;
import com.tencent.mm.protocal.a.a.f;
import com.tencent.mm.protocal.c.ace;
import com.tencent.mm.protocal.c.acf;
import com.tencent.mm.protocal.c.ami;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends l implements k {
    private static boolean bgH = false;
    private static Object lock = new Object();
    private b diG;
    private e diJ;
    private a mDQ = new a();
    private ace mDU = null;

    public static boolean isRunning() {
        boolean z;
        synchronized (lock) {
            z = bgH;
        }
        return z;
    }

    private static void hs(boolean z) {
        synchronized (lock) {
            bgH = z;
        }
    }

    public h() {
        hs(true);
        this.mDU = SmcProtoBufUtil.toMMGetStrategyReq();
        if (this.mDU != null) {
            this.mDU.rtn = new ami();
            this.mDU.rtn.rOY = a.vs(0);
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (g.Eh().dpP == null || g.Eh().dpP.dJs == null) {
            x.f("MicroMsg.NetSceneGetCliKVStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
            this.diJ.a(i2, i3, str, this);
        } else if (i2 != 0) {
            x.e("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy err, errType:" + i2 + ", errCode:" + i3);
            SmcLogic.OnStrategyResp(i2, i3, null, 1);
            SmcLogic.OnStrategyResp(i2, i3, null, 2);
            this.diJ.a(i2, i3, str, this);
            hs(false);
        } else {
            x.d("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy ok");
            acf acf = (acf) this.diG.dIE.dIL;
            this.mDQ.a(acf.rtx, 0);
            try {
                f toSmcKVStrategyResp = SmcProtoBufUtil.toSmcKVStrategyResp(acf);
                c toSmcIdkeyStrategyResp = SmcProtoBufUtil.toSmcIdkeyStrategyResp(acf);
                SmcLogic.OnStrategyResp(0, 0, toSmcKVStrategyResp.toByteArray(), 1);
                SmcLogic.OnStrategyResp(0, 0, toSmcIdkeyStrategyResp.toByteArray(), 2);
            } catch (Throwable e) {
                x.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", new Object[]{Integer.valueOf(hashCode()), bi.i(e)});
            }
            this.diJ.a(i2, i3, str, this);
            hs(false);
        }
    }

    public final int getType() {
        g.Eg();
        return a.Dw() ? 988 : 989;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        g.Eg();
        boolean Dw = a.Dw();
        if (!Dw) {
            this.mDU.rtm = com.tencent.mm.bk.b.bi(bi.ciV());
        }
        b.a aVar = new b.a();
        aVar.dIK = false;
        aVar.dIG = this.mDU;
        aVar.dIH = new acf();
        aVar.uri = Dw ? "/cgi-bin/micromsg-bin/getkvidkeystrategy" : "/cgi-bin/micromsg-bin/getkvidkeystrategyrsa";
        aVar.dIF = getType();
        this.diG = aVar.KT();
        if (!Dw) {
            this.diG.a(y.cgs());
            this.diG.cdn = 1;
        }
        int a = a(eVar, this.diG, this);
        if (a < 0) {
            x.i("MicroMsg.NetSceneGetCliKVStrategy", "mark all failed. do scene %d", new Object[]{Integer.valueOf(a)});
            try {
                SmcLogic.OnStrategyResp(3, -1, null, 1);
                SmcLogic.OnStrategyResp(3, -1, null, 2);
                hs(false);
            } catch (Throwable e) {
                x.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", new Object[]{Integer.valueOf(hashCode()), bi.i(e)});
            }
        }
        return a;
    }
}
