package com.tencent.mm.modelstat;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bfj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;

class o$2 implements a {
    final /* synthetic */ float eee;
    final /* synthetic */ float eef;
    final /* synthetic */ int eeh;
    final /* synthetic */ long ekP;
    final /* synthetic */ bfj ekQ;
    final /* synthetic */ String[] ekR;
    final /* synthetic */ long ekS;

    o$2(long j, bfj bfj, String[] strArr, float f, float f2, int i, long j2) {
        this.ekP = j;
        this.ekQ = bfj;
        this.ekR = strArr;
        this.eee = f;
        this.eef = f2;
        this.eeh = i;
        this.ekS = j2;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        x.d("MicroMsg.NetTypeReporter", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(bi.bH(this.ekP)), this.ekQ.mEl});
        if (!(i == 0 && i2 == 0)) {
            long bH = bi.bH(o.access$100());
            if (bH > 600000 || bH < 0) {
                bH = 0;
            }
            h.mEJ.k(11747, this.ekR[0] + "1," + this.eee + "," + this.eef + "," + this.eeh + "," + this.ekS + "," + (com.tencent.mm.sdk.a.b.foreground ? "1" : String.valueOf(bH)) + "," + this.ekR[1] + "," + this.ekR[2] + "," + this.ekR[3]);
        }
        g.Ei().DT().a(aa.a.sPu, Long.valueOf(bi.VF()));
        return 0;
    }
}
