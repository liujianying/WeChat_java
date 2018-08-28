package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.a.a.h;
import com.tencent.mm.protocal.c.m;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.vending.g.b;

public final class d implements e {
    private static int eAg = 20;
    private static int eAh = 20;
    private static int eAi = 20;
    private static long eAj = 4000000;
    private static long eAk = 200000;
    b eAc;
    public String eAl = "";
    public String eAm = "";

    private d(String str, String str2) {
        this.eAl = str;
        this.eAm = str2;
    }

    public static int VU() {
        g.Ek();
        return ((Integer) g.Ei().DT().get(a.sUq, Integer.valueOf(eAg))).intValue();
    }

    public static int VV() {
        g.Ek();
        return ((Integer) g.Ei().DT().get(a.sUs, Integer.valueOf(eAi))).intValue();
    }

    public static long VW() {
        g.Ek();
        return ((Long) g.Ei().DT().get(a.sUu, Long.valueOf(eAk))).longValue();
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.AAOperationData", "get AAOperation, onSceneEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            m mVar = ((h) lVar).eAV;
            x.i("MicroMsg.AAOperationData", "get AAOperation data, retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", new Object[]{Integer.valueOf(mVar.hUm), mVar.hUn, Integer.valueOf(mVar.qYq), Integer.valueOf(mVar.qYr), Integer.valueOf(mVar.qYs), Long.valueOf(mVar.qYt), Long.valueOf(mVar.qYu), mVar.hUy, mVar.hUz});
            if (mVar.hUm == 0) {
                g.Ek();
                g.Ei().DT().a(a.sUq, Integer.valueOf(mVar.qYq));
                g.Ek();
                g.Ei().DT().a(a.sUr, Integer.valueOf(mVar.qYr));
                g.Ek();
                g.Ei().DT().a(a.sUs, Integer.valueOf(mVar.qYs));
                g.Ek();
                g.Ei().DT().a(a.sUt, Long.valueOf(mVar.qYt));
                g.Ek();
                g.Ei().DT().a(a.sUu, Long.valueOf(mVar.qYu));
                com.tencent.mm.plugin.report.service.h.mEJ.a(407, 33, 1, false);
                com.tencent.mm.vending.g.g.a(this.eAc, new Object[]{new d(mVar.hUz, mVar.hUy)});
                return;
            }
            com.tencent.mm.vending.g.g.cBF().ct(Boolean.valueOf(false));
            com.tencent.mm.plugin.report.service.h.mEJ.a(407, 35, 1, false);
            return;
        }
        com.tencent.mm.vending.g.g.cBF().ct(Boolean.valueOf(false));
        com.tencent.mm.plugin.report.service.h.mEJ.a(407, 34, 1, false);
    }
}
