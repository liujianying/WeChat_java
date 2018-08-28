package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.av;
import java.util.List;

class g$4 implements Runnable {
    final /* synthetic */ g nnr;
    final /* synthetic */ int nns = 0;
    final /* synthetic */ List nnv;
    final /* synthetic */ av nnw;

    g$4(g gVar, List list, av avVar) {
        this.nnr = gVar;
        this.nnv = list;
        this.nnw = avVar;
    }

    public final void run() {
        long VG = bi.VG();
        e eVar = new e(this.nnv);
        eVar.kJG = i.cf(this.nnv);
        eVar.nkQ = this.nns;
        int i = 0;
        int i2 = 1;
        while (i < this.nnv.size() && i < 4) {
            ate ate = (ate) this.nnv.get(i);
            b byj = af.byj();
            String str = ate.ksA;
            int i3 = byj.nmI.containsKey(i.aF(1, str)) ? 1 : byj.nmI.containsKey(i.aF(5, str)) ? 1 : 0;
            if (i3 != 0) {
                i2 = 0;
            } else if (!(FileOp.cn(an.s(af.getAccSnsPath(), ate.ksA) + i.e(ate)) || FileOp.cn(an.s(af.getAccSnsPath(), ate.ksA) + i.l(ate)) || FileOp.cn(an.s(af.getAccSnsPath(), ate.ksA) + i.m(ate)))) {
                byj = af.byj();
                if (ate.hcE == 6) {
                    i2 = 5;
                } else {
                    i2 = 1;
                }
                byj.a(ate, i2, eVar, this.nnw);
                i2 = 0;
            }
            i++;
        }
        long bI = bi.bI(VG);
        if (bI > 100) {
            x.i("MicroMsg.LazyerImageLoader2", "fileexist check2  endtime " + bI + " " + Thread.currentThread().getName() + " " + com.tencent.mm.compatible.util.e.bnC + " " + af.byB() + " " + eVar.kJG);
        }
        if (bi.bI(g.c(this.nnr)) > 60000) {
            h.mEJ.h(11696, new Object[]{Integer.valueOf(1), Long.valueOf(bI), Integer.valueOf(0), Thread.currentThread().getName(), af.byB(), com.tencent.mm.compatible.util.e.bnC});
            g.a(this.nnr, bi.VG());
        }
        String cf = i.cf(this.nnv);
        if (i2 != 0) {
            af.aRu().post(new 1(this, cf));
        }
    }
}
