package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.mn;
import com.tencent.mm.protocal.c.mo;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardSetCode";
    private b diG;
    private e diJ;
    public mo hVd;

    public g(LinkedList<Integer> linkedList, String str, boolean z, boolean z2) {
        a aVar = new a();
        aVar.dIG = new mn();
        aVar.dIH = new mo();
        aVar.dIF = 1562;
        aVar.uri = "/cgi-bin/mmpay-bin/setrewardqrcode";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        mn mnVar = (mn) this.diG.dID.dIL;
        mnVar.rqc = linkedList;
        mnVar.desc = str;
        mnVar.rqC = z;
        mnVar.rqD = z2;
        x.i("MicroMsg.NetSceneQrRewardSetCode", "desc: %s, flag: %s, default: %s", new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)});
    }

    public final int getType() {
        return 1562;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneQrRewardSetCode", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.hVd = (mo) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneQrRewardSetCode", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.hVd.hUm), this.hVd.hUn});
        if (!(this.hUU || this.hVd.hUm == 0)) {
            this.hUV = true;
        }
        if (!this.hUU && !this.hUV) {
            com.tencent.mm.kernel.g.Ei().DT().a(aa.a.sYN, Integer.valueOf(this.hVd.rqf));
            com.tencent.mm.kernel.g.Ei().DT().a(aa.a.sYO, Integer.valueOf(this.hVd.rqb));
            com.tencent.mm.kernel.g.Ei().DT().a(aa.a.sYQ, this.hVd.desc);
            com.tencent.mm.kernel.g.Ei().DT().a(aa.a.sYW, this.hVd.mwO);
            List arrayList = new ArrayList();
            Iterator it = this.hVd.rqc.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(((Integer) it.next()).intValue()));
            }
            com.tencent.mm.kernel.g.Ei().DT().a(aa.a.sYT, bi.c(arrayList, ","));
            h.mEJ.a(724, 5, 1, false);
        } else if (this.hUU) {
            h.mEJ.a(724, 7, 1, false);
        } else {
            h.mEJ.a(724, 6, 1, false);
        }
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }
}
