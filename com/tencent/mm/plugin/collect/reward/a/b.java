package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.lw;
import com.tencent.mm.protocal.c.lx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardGetCode";
    private com.tencent.mm.ab.b diG;
    private e diJ;
    public lx hUX;
    public boolean hUY;

    public b(boolean z) {
        a aVar = new a();
        aVar.dIG = new lw();
        aVar.dIH = new lx();
        aVar.dIF = 1323;
        aVar.uri = "/cgi-bin/mmpay-bin/getrewardqrcode";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((lw) this.diG.dID.dIL).rpY = z;
        this.hUY = z;
    }

    public final int getType() {
        return 1323;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    protected final boolean aBP() {
        return false;
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneQrRewardGetCode", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.hUX = (lx) ((com.tencent.mm.ab.b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneQrRewardGetCode", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.hUX.hUm), this.hUX.hUn});
        if (!(this.hUU || this.hUX.hUm == 0)) {
            this.hUV = true;
        }
        if (!this.hUU && !this.hUV) {
            g.Ei().DT().a(aa.a.sYN, Integer.valueOf(this.hUX.rqf));
            g.Ei().DT().a(aa.a.sYO, Integer.valueOf(this.hUX.rqb));
            g.Ei().DT().a(aa.a.sYQ, this.hUX.desc);
            g.Ei().DT().a(aa.a.sYP, this.hUX.hqp);
            g.Ei().DT().a(aa.a.sYS, Integer.valueOf(this.hUX.rqe));
            g.Ei().DT().a(aa.a.sYU, this.hUX.hwH);
            g.Ei().DT().a(aa.a.sYV, this.hUX.rqd);
            g.Ei().DT().a(aa.a.sYW, this.hUX.mwO);
            List arrayList = new ArrayList();
            Iterator it = this.hUX.rqc.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(((Integer) it.next()).intValue()));
            }
            g.Ei().DT().a(aa.a.sYT, bi.c(arrayList, ","));
            h.mEJ.a(724, 2, 1, false);
        } else if (this.hUU) {
            h.mEJ.a(724, 4, 1, false);
        } else {
            h.mEJ.a(724, 3, 1, false);
        }
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }
}
