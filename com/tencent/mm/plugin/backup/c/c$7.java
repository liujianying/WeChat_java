package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.f.j;
import com.tencent.mm.plugin.backup.h.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class c$7 implements e {
    final /* synthetic */ c gUr;

    c$7(c cVar) {
        this.gUr = cVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        b.b(3, c.i(this.gUr));
        x.i("MicroMsg.BackupMoveRecoverServer", "backupmove receive startrequest response.[%d,%d,%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            j jVar = (j) lVar;
            o oVar = jVar.gYv;
            if (b.arv().gRu.equals(oVar.ID)) {
                double d;
                b.arv().aqP().gRF = oVar.hbV;
                this.gUr.byN = jVar.gYv.hbY.hbO;
                if (jVar.gYv.hbY.hbR.toLowerCase().contains("ios")) {
                    c.a(this.gUr, 1);
                } else {
                    c.a(this.gUr, 2);
                }
                c.a(this.gUr, jVar.gYv.hcc);
                c.b(this.gUr, jVar.gYv.hce);
                x.i("MicroMsg.BackupMoveRecoverServer", "move recover totalCount[%d], totalSize[%d], and wait old mobile's pushData", new Object[]{Long.valueOf(jVar.gYv.hcb), Long.valueOf(jVar.gYv.hcc)});
                if (c.j(this.gUr) && c.g(this.gUr)) {
                    h hVar = h.mEJ;
                    int i3 = (c.k(this.gUr) || c.l(this.gUr) == 1) ? 66 : 65;
                    hVar.a(485, (long) i3, 1, false);
                }
                if ((jVar.gYv.hca == 3 ? 1 : null) != null) {
                    c.c(this.gUr, true);
                    x.i("MicroMsg.BackupMoveRecoverServer", "isQuickBackup!!!");
                } else {
                    c.c(this.gUr, false);
                }
                PLong pLong = new PLong();
                PLong pLong2 = new PLong();
                au.HU();
                g.a(pLong, pLong2, c.Gq());
                long m = c.m(this.gUr);
                if (((double) c.m(this.gUr)) * 0.1d > 5.24288E8d) {
                    d = 5.24288E8d;
                } else {
                    d = ((double) c.m(this.gUr)) * 0.1d;
                }
                long j = ((long) d) + m;
                this.gUr.gUm = j;
                if (pLong2.value < j) {
                    x.e("MicroMsg.BackupMoveRecoverServer", "startRequestNotify Not Enough Space:%d < dataSize:%d, dataSize:%d", new Object[]{Long.valueOf(pLong2.value), Long.valueOf(j), Long.valueOf(c.m(this.gUr))});
                    h.mEJ.h(11787, new Object[]{Integer.valueOf(5)});
                    b.arv().arw().stop();
                    b.arv().aqP().gRC = -13;
                    this.gUr.mw(-13);
                    h.mEJ.a(485, 5, 1, false);
                    return;
                }
                c.b(this.gUr, bi.VF());
                return;
            }
            x.e("MicroMsg.BackupMoveRecoverServer", "start response not the same id");
            b.arv().aqP().gRC = -5;
            this.gUr.mw(-5);
            return;
        }
        x.e("MicroMsg.BackupMoveRecoverServer", "start request failed, errMsg:" + str);
        b.arv().aqP().gRC = -5;
        this.gUr.mw(-5);
    }
}
