package com.tencent.mrs.a;

import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ag;
import com.tencent.mm.protocal.c.ys;
import com.tencent.mm.protocal.c.yt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends l implements k {
    private static boolean bgH = false;
    private static Object lock = new Object();
    private com.tencent.mm.ab.b diG;
    private e diJ;
    private ys mDS = null;

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

    public b(byte[] bArr) {
        hs(true);
        ag agVar = new ag();
        this.mDS = new ys();
        try {
            agVar.aG(bArr);
            this.mDS.rEW = agVar;
        } catch (Exception e) {
            x.e("Matrix.NetSceneGetMrsStrategy", "parse data error");
            g.Ek();
            g.Em().H(new Runnable() {
                public final void run() {
                    MatrixReport.with().onStrategyResp(3, -1, null);
                }
            });
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        try {
            if (g.Eh().dpP == null || g.Eh().dpP.dJs == null) {
                x.f("Matrix.NetSceneGetMrsStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
                this.diJ.a(i2, i3, str, this);
                hs(false);
            } else if (i2 != 0) {
                x.e("Matrix.NetSceneGetMrsStrategy", "get report strategy err, errType:" + i2 + ", errCode:" + i3);
                MatrixReport.with().onStrategyResp(i2, i3, null);
                this.diJ.a(i2, i3, str, this);
                hs(false);
            } else {
                x.d("Matrix.NetSceneGetMrsStrategy", "get report strategy ok");
                MatrixReport.with().onStrategyResp(0, 0, ((yt) this.diG.dIE.dIL).rEX.toByteArray());
                this.diJ.a(i2, i3, str, this);
                hs(false);
            }
        } catch (Throwable e) {
            x.e("Matrix.NetSceneGetMrsStrategy", "failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), bi.i(e));
        } catch (Throwable th) {
            hs(false);
        }
    }

    public final int getType() {
        return 914;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i;
        int i2 = -1;
        this.diJ = eVar2;
        if (bi.bC(g.Eh().DE())) {
            boolean i3 = false;
        } else {
            i3 = 1;
        }
        if (i3 == 0) {
            x.w("Matrix.NetSceneGetMrsStrategy", "get mrs strategy must go after login");
        } else {
            a aVar = new a();
            aVar.dIK = false;
            aVar.dIG = this.mDS;
            aVar.dIH = new yt();
            aVar.uri = "/cgi-bin/micromsg-bin/getapmstrategy";
            aVar.dIF = 914;
            this.diG = aVar.KT();
            i2 = a(eVar, this.diG, this);
            if (i2 < 0) {
                x.i("Matrix.NetSceneGetMrsStrategy", "mark all failed. do scene %d", Integer.valueOf(i2));
                try {
                    MatrixReport.with().onStrategyResp(3, -1, null);
                    hs(false);
                } catch (Throwable e) {
                    x.e("Matrix.NetSceneGetMrsStrategy", "onStrategyResp failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), bi.i(e));
                }
            }
        }
        return i2;
    }
}
