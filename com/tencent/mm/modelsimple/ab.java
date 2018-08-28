package com.tencent.mm.modelsimple;

import com.tencent.mm.a.o;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.bxv;
import com.tencent.mm.protocal.c.bxw;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class ab extends l implements k {
    public b diG;
    private e diJ;
    public long egu;

    public ab(String str, String str2, String str3, String str4) {
        this(1, str, str2, str3, str4, false, 0);
    }

    public ab(int i, String str, String str2, String str3, String str4, boolean z, int i2) {
        this(i, str, str2, str3, str4, z, i2, true);
    }

    public ab(int i, String str, String str2, String str3, String str4, boolean z, int i2, boolean z2) {
        this.egu = 0;
        a aVar = new a();
        aVar.dIG = new bxv();
        aVar.dIH = new bxw();
        aVar.uri = "/cgi-bin/micromsg-bin/newverifypasswd";
        aVar.dIF = 384;
        aVar.dII = 182;
        aVar.dIJ = 1000000182;
        this.diG = aVar.KT();
        bxv bxv = (bxv) this.diG.dID.dIL;
        bxv.qZc = i;
        bxv.skH = i2;
        bxv.stV = bi.WO(str);
        bxv.rhU = bi.WN(str);
        bxv.rMn = new bhz().VO(str2);
        bxv.stW = new bhz().VO(str3);
        bxv.rhY = new bhz().VO(str4);
        if (i == 5 || i == 2) {
            byte[] c;
            this.egu = new o(q.GE()).longValue();
            if (z) {
                c = g.Eg().Dp().c(this.egu, str3);
            } else {
                c = g.Eg().Dp().a(this.egu, bi.WO(str), z2);
            }
            bxv.rgk = new bhy().bq(c);
        }
        bxv.rhZ = new bhy().bq(bi.WP(bi.oV((String) g.Ei().DT().get(47, null))));
        String str5 = "MicroMsg.NetSceneVerifyPswd";
        String str6 = "summerauth opCode[%d], hasSecCode[%b], isManualAuth[%b], len:%d, content:[%s]";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(bxv.qZc);
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Boolean.valueOf(z2);
        objArr[3] = Integer.valueOf(bxv.rgk == null ? -1 : bxv.rgk.siI);
        objArr[4] = bxv.rgk == null ? "null" : bi.Xf(bi.bB(bxv.rgk.siK.lR));
        x.i(str5, str6, objArr);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 384;
    }

    public final String Oj() {
        try {
            return ((bxw) this.diG.dIE.dIL).rwj;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneVerifyPswd", e, "", new Object[0]);
            return null;
        }
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        bxv bxv = (bxv) this.diG.dID.dIL;
        bxw bxw = (bxw) this.diG.dIE.dIL;
        if (bxw.rev != null && bxw.rev.siI > 0) {
            boolean a = g.Eg().Dp().a(this.egu, com.tencent.mm.platformtools.ab.a(bxw.rev));
            x.i("MicroMsg.NetSceneVerifyPswd", "summerauth parseRet[%b], len[%d]", new Object[]{Boolean.valueOf(a), Integer.valueOf(bxw.rev.siI)});
        }
        if (i2 == 0 && i3 == 0) {
            g.Ei().DT().set(77830, bxw.rwj);
            g.Ei().DT().set(32, bxv.stV);
            g.Ei().DT().set(33, bxv.rhU);
            g.Ei().DT().set(46, bi.bE(com.tencent.mm.platformtools.ab.a(bxw.reB)));
            String bE = bi.bE(com.tencent.mm.platformtools.ab.a(bxv.rhZ));
            g.Ei().DT().set(47, bE);
            g.Ei().dqk.set(18, bE);
            g.Ei().DT().set(-1535680990, bxw.reA);
            int i4 = bxw.reB == null ? 0 : bxw.reB.siI;
            int length = bxw.reA == null ? 0 : bxw.reA.length();
            int length2 = bxw.rwj == null ? 0 : bxw.rwj.length();
            x.i("MicroMsg.NetSceneVerifyPswd", "A2Key.len %d, authKey.len: %d, ticketLen:%d", new Object[]{Integer.valueOf(i4), Integer.valueOf(length), Integer.valueOf(length2)});
        } else if (i2 == 4) {
            g.Ei().DT().set(32, "");
            g.Ei().DT().set(33, "");
        }
        this.diJ.a(i2, i3, str, this);
    }
}
