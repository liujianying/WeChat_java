package com.tencent.mm.plugin.account.bind.a;

import com.tencent.mm.a.o;
import com.tencent.mm.aa.c;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.hi;
import com.tencent.mm.protocal.c.hj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends l implements k {
    private String bQX;
    private String bQZ;
    public final com.tencent.mm.ab.b diG;
    private e diJ;
    public long egu;

    public b(long j, String str, String str2, String str3, String str4, int i, boolean z) {
        byte[] c;
        this.egu = 0;
        a aVar = new a();
        aVar.dIG = new hi();
        aVar.dIH = new hj();
        aVar.uri = "/cgi-bin/micromsg-bin/bindqq";
        aVar.dIF = 144;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.egu = j;
        hi hiVar = (hi) this.diG.dID.dIL;
        hiVar.rhT = new o(j).intValue();
        hiVar.rhI = "";
        hiVar.rhU = "";
        hiVar.rhV = "";
        hiVar.rhW = "";
        hiVar.rhY = new bhz().VO("");
        hiVar.rhX = 1;
        if (z) {
            c = g.Eg().Dp().c(j, str3);
        } else {
            c = g.Eg().Dp().a(j, bi.WO(str), true);
        }
        hiVar.rgk = new bhy().bq(c);
        hiVar.rhZ = new bhy().bq(bi.WP(bi.oV((String) g.Ei().DT().get(47, null))));
        x.i("MicroMsg.NetSceneBindQQ", "init opcode:%d qq:%d  wtbuf:%d img[%s,%s,%s] ksid:%s", new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(bi.bD(c)), str3, str2, str4, r1});
    }

    public b(long j, String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        this(j, str, str2, str3, str4, 1, z);
        this.bQX = str5;
        this.bQZ = str6;
        hi hiVar = (hi) this.diG.dID.dIL;
        hiVar.rhz = str5;
        hiVar.rhA = str6;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 144;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        boolean z;
        hi hiVar = (hi) this.diG.dID.dIL;
        hj hjVar = (hj) this.diG.dIE.dIL;
        byte[] a = ab.a(hjVar.rev);
        if (bi.bC(a)) {
            z = false;
        } else {
            z = g.Eg().Dp().a(new o(hiVar.rhT).longValue(), a);
        }
        x.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd[%d,%d] wtret:%b wtRespBuf:%d imgsid:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(bi.bD(a)), hjVar.rhV});
        if (i2 == 0 && i3 == 0) {
            g.Ei().DT().set(9, Integer.valueOf(hiVar.rhT));
            if (hiVar.rhX == 1) {
                g.Ei().DT().set(17, Integer.valueOf(hjVar.raH));
            }
            ((i) g.l(i.class)).FZ().aF(hjVar.ric, hjVar.rib == 1);
            int i4 = hiVar.rhT;
            if (i4 != 0) {
                ((i) g.l(i.class)).FZ().bJ(new o(i4) + "@qqim", 3);
            }
            c.d((long) i4, 3);
            g.Ei().DT().set(32, hiVar.rhI);
            g.Ei().DT().set(33, hiVar.rhU);
            x.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd wtret:%b newa2key:%s ", new Object[]{Boolean.valueOf(z), bi.Xf(bi.bE(g.Eg().Dp().bb(new o(hiVar.rhT).longValue())))});
            g.Ei().DT().set(72, r2);
            g.Ei().DT().set(46, bi.bE(ab.a(hjVar.reB)));
            String bE = bi.bE(ab.a(hiVar.rhZ));
            g.Ei().DT().set(47, bE);
            g.Ei().dqk.set(18, bE);
            g.Ei().DT().set(-1535680990, hjVar.rid);
        } else if (i2 == 4) {
            g.Ei().DT().set(32, "");
            g.Ei().DT().set(33, "");
        }
        if (hiVar.rhX == 3 && i3 == -3) {
            i3 = 10000;
            x.d("MicroMsg.NetSceneBindQQ", "onGYNetEnd : retCode = 10000");
        }
        this.diJ.a(i2, i3, str, this);
    }
}
