package com.tencent.mm.modelvideo;

import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class o$4 implements Runnable {
    final /* synthetic */ o enE;

    o$4(o oVar) {
        this.enE = oVar;
    }

    public final void run() {
        if (g.Eg().Dx()) {
            s Ta = o.Ta();
            x.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", new Object[]{"UPDATE videoinfo2 SET status = 198, lastmodifytime = " + (System.currentTimeMillis() / 1000) + " WHERE masssendid > 0  AND status = 200"});
            Ta.dCZ.fV("videoinfo2", r1);
            o.Te().diF.fV("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 1 WHERE fileStatus = 6");
            l Te = o.Te();
            if (1209600000 <= 0) {
                x.w("MicroMsg.SightDraftStorage", "keep 0 sight draft");
                Te.diF.fV("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1");
            } else {
                x.i("MicroMsg.SightDraftStorage", "check delete ITEM, create time %d", new Object[]{Long.valueOf(bi.VF() - 1209600000)});
                Te.diF.fV("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1 AND createTime < " + r2);
            }
            for (j jVar : o.Te().SV()) {
                x.i("MicroMsg.SubCoreVideo", "do delete sight draft file, name %s", new Object[]{jVar.field_fileName});
                e.deleteFile(k.nB(jVar.field_fileName));
                e.deleteFile(k.nC(jVar.field_fileName));
            }
        }
    }
}
