package com.tencent.mm.modelmulti;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.avy;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.r;
import com.tencent.mm.protocal.r.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

public final class f extends l implements k {
    private final al dHa = new al(g.Em().lnJ.getLooper(), new 1(this), true);
    final Queue<a> dSN = new LinkedList();
    com.tencent.mm.ab.f dVg = null;
    a dYW;
    private StringBuilder dYX = new StringBuilder();
    final avx dZh = new avx();
    int dZi = 0;
    boolean dZj = false;
    int dZk = 0;
    int dZl = 0;
    boolean dZm = false;
    e diJ;
    private int retryCount = 3;

    public f(com.tencent.mm.ab.f fVar) {
        x.i("MicroMsg.NetSceneInit.dkInit", "NetSceneInit hash:%d stack:%s", new Object[]{Integer.valueOf(hashCode()), bi.cjd()});
        this.dYX.append("stack:" + bi.cjd() + " time:" + bi.VE());
        this.dVg = fVar;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.dYW = new a();
        this.diJ = eVar2;
        avx avx = this.dZh;
        g.Ek();
        avx.hbL = (String) g.Ei().DT().get(2, null);
        Assert.assertTrue("by DK: req.UserName is null", !bi.oW(this.dZh.hbL));
        this.dZh.iwP = w.chP();
        return a(eVar, null, null);
    }

    private int a(com.tencent.mm.network.e eVar, bhy bhy, bhy bhy2) {
        this.dYX.append(" lastd:" + this.dIY + " dotime:" + bi.VE() + " net:" + ao.getNetType(ad.getContext()));
        b bVar = new b();
        if (bhy == null) {
            g.Ek();
            bhy = ab.O(bi.WP(bi.oV((String) g.Ei().DT().get(8197, null))));
        }
        if (bhy2 == null) {
            g.Ek();
            bhy2 = ab.O(bi.WP(bi.oV((String) g.Ei().DT().get(8198, null))));
        }
        g.Ek();
        if (bi.f((Integer) g.Ei().DT().get(16, null)) == 0 || (bhy != null && bhy.siI > 0)) {
            g.Ek();
            if (bi.oV((String) g.Ei().DT().get(8195, null)).length() <= 0) {
                bVar.KV().qWw = 3;
            } else {
                bVar.KV().qWw = 4;
            }
        } else {
            bVar.KV().qWw = 7;
        }
        this.dZh.rYQ = bhy;
        this.dZh.rYR = bhy2;
        ((r.a) bVar.KV()).qWU = this.dZh;
        x.i("MicroMsg.NetSceneInit.dkInit", "doScene hash:%d time:%d count:%d user%s lan:%s status:%d cur[%s] max[%s]", new Object[]{Integer.valueOf(hashCode()), Long.valueOf(this.dYW.Ad()), Integer.valueOf(this.dZi), this.dZh.hbL, this.dZh.iwP, Integer.valueOf(bVar.KV().qWw), bi.bE(ab.a(bhy)), bi.bE(ab.a(bhy2))});
        this.dZi++;
        return a(eVar, bVar, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.dYX.append(" endtime:" + bi.VE());
        x.i("MicroMsg.NetSceneInit.dkInit", "summerinit onGYNetEnd [%d, %d, %s], tid:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i)});
        if (i2 == 4 && i3 == -100) {
            x.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR hash:%d [%d,%d] KICK OUT : %s", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), str});
            this.dZm = true;
            this.diJ.a(i2, i3, str, this);
        } else if ((i2 == 0 && i3 == 0) || (i2 == 4 && i3 == -17)) {
            avy avy = ((b) qVar.Id()).qWV;
            this.dZk += avy.rYT;
            x.i("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd hash:%d [%d,%d] time:%d cmdSum:%d doscenecount:%d conFlag:%d", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(this.dYW.Ad()), Integer.valueOf(this.dZk), Integer.valueOf(this.dZi), Integer.valueOf(avy.rlm)});
            a(this.dZi - 1, i2, i3, str, avy);
            if ((avy.rlm & 7) == 0 || super.KY()) {
                x.i("MicroMsg.NetSceneInit.dkInit", "NETWORK FINISH onGYNetEnd hash:%d time:%d netCnt:%d", new Object[]{Integer.valueOf(hashCode()), Long.valueOf(this.dYW.Ad()), Integer.valueOf(this.dZi)});
                this.dZj = true;
                a(Integer.MAX_VALUE, 0, 0, "", null);
            } else if (a(this.dIX, avy.rYQ, avy.rYR) == -1) {
                x.e("MicroMsg.NetSceneInit.dkInit", "doScene Failed stop init");
                a(Integer.MAX_VALUE, 3, -1, "", null);
            }
        } else {
            x.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR retry:%d hash:%d [%d,%d] %s", new Object[]{Integer.valueOf(this.retryCount), Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), str});
            if (this.retryCount > 0) {
                this.retryCount--;
                if (a(this.dIX, null, null) != -1) {
                    return;
                }
            }
            this.dZm = true;
            this.diJ.a(3, -1, "", this);
        }
    }

    public final boolean KX() {
        return true;
    }

    protected final void cancel() {
        x.w("MicroMsg.NetSceneInit.dkInit", "init cancel by :%s", new Object[]{bi.cjd()});
        super.cancel();
        this.dZm = true;
    }

    private void a(int i, int i2, int i3, String str, avy avy) {
        a aVar = new a(this);
        aVar.dZr = i;
        aVar.errCode = i3;
        aVar.errType = i2;
        aVar.Yy = str;
        aVar.dZq = avy;
        this.dSN.add(aVar);
        if (this.dHa.ciq()) {
            this.dHa.J(50, 50);
        }
    }

    public final String getInfo() {
        return this.dYX.toString();
    }

    protected final int Cc() {
        return 500;
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }

    public final boolean KY() {
        return super.KY();
    }

    public final int getType() {
        return 139;
    }
}
