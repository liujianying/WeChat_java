package com.tencent.mm.booter;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.booter.k.2;
import com.tencent.mm.g.a.dk;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelmulti.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.aag;
import com.tencent.mm.protocal.c.ane;
import com.tencent.mm.protocal.c.anj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.aa.a;

class k$2$1 implements e {
    final /* synthetic */ d cXv;
    final /* synthetic */ 2 cXw;

    k$2$1(2 2, d dVar) {
        this.cXw = 2;
        this.cXv = dVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0) {
            aag aag = (aag) this.cXv.dZf.dIE.dIL;
            if (aag.result == 0) {
                anj anj = aag.rFL;
                ane ane = aag.rFN;
                String str2 = anj.title + "," + anj.desc + "," + anj.rPX + "," + anj.rPY + "," + ane.fMk + "," + ane.major + "," + ane.minor;
                au.HU();
                String[] split = bi.aG((String) c.DT().get(a.sRR, null), "").split(",");
                Boolean valueOf = Boolean.valueOf(false);
                for (String equals : split) {
                    if (equals.equals(ane.fMk + ane.major + ane.minor)) {
                        valueOf = Boolean.valueOf(true);
                    }
                }
                if (valueOf.booleanValue()) {
                    au.HU();
                    c.DT().a(a.sRQ, "");
                } else {
                    h.mEJ.h(12653, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
                    h.mEJ.h(12653, new Object[]{Integer.valueOf(2), Integer.valueOf(1)});
                    au.HU();
                    c.DT().a(a.sRQ, str2);
                }
            } else {
                au.HU();
                c.DT().a(a.sRQ, "");
            }
        } else {
            au.HU();
            c.DT().a(a.sRQ, "");
        }
        au.HU();
        c.Dt();
        com.tencent.mm.sdk.b.a.sFg.m(new dk());
        k.b(Boolean.valueOf(false));
        au.DF().b(1708, this);
    }
}
