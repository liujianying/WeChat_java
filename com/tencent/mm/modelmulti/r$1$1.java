package com.tencent.mm.modelmulti;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelmulti.r.1;
import com.tencent.mm.protocal.c.awe;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.protocal.c.pm;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.protocal.s.b;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;

class r$1$1 implements a {
    int eaX = this.eaY.eaV;
    final /* synthetic */ 1 eaY;

    r$1$1(1 1) {
        this.eaY = 1;
    }

    public final boolean vD() {
        if (this.eaX <= 0) {
            return false;
        }
        this.eaX--;
        b bVar = new b();
        bVar.qWX.rnB = new pn();
        int eF = bi.eF(this.eaY.eaW, 1);
        for (int i = 0; i < eF; i++) {
            by byVar = (by) r.PS().get(bi.eF(r.PS().size() - 1, 0));
            byVar.rcj = new bhz().VO(((ab) r.PR().get(bi.eF(r.PR().size() - 1, 0))).field_username);
            byVar.lOH = (int) bi.VE();
            byVar.rcq = (long) Math.abs(((int) bi.VF()) % 10000000);
            try {
                pm pmVar = new pm();
                pmVar.rtN = new bhy();
                pmVar.rtN.bq(byVar.toByteArray());
                pmVar.rtM = 5;
                bVar.qWX.rnB.hbG.add(pmVar);
                pn pnVar = bVar.qWX.rnB;
                pnVar.hbF++;
                x.d("MicroMsg.TestSyncAddMsg", "syncAddMsg  loop:%d cnt:[%d,%d] cmdList:%d id:%d u:%s", new Object[]{Integer.valueOf(this.eaX), Integer.valueOf(i), Integer.valueOf(eF), Integer.valueOf(bVar.qWX.rnB.hbG.size()), Long.valueOf(byVar.rcq), byVar.rcj.siM});
            } catch (Throwable e) {
                x.d("MicroMsg.TestSyncAddMsg", e.getMessage());
                x.printErrStackTrace("MicroMsg.TestSyncAddMsg", e, "", new Object[0]);
            }
        }
        bVar.qWX.rlm = 0;
        awe awe = bVar.qWX;
        au.HU();
        awe.rny = com.tencent.mm.platformtools.ab.O(bi.WP(bi.oV((String) c.DT().get(8195, new byte[0]))));
        bVar.qWX.rfn = 0;
        bVar.qWX.hcd = 0;
        o.PM().a(bVar, 0, bi.VE());
        return true;
    }
}
