package com.tencent.mm.plugin.sns.abtest;

import com.tencent.mm.g.a.gc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class a$2 extends c<gc> {
    a$2() {
        this.sFo = gc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        gc gcVar = (gc) bVar;
        if (gcVar instanceof gc) {
            boolean z = gcVar.bPk.bPl;
            long j = gcVar.bPk.bPm;
            x.d("MicroMsg.NotInteresetABTestManager", "notInterestFinishEventListener callback, isNotInterest:%b, sndId:%d", new Object[]{Boolean.valueOf(z), Long.valueOf(j)});
            if (!(j == 0 || a.ty() == 0 || j != a.ty())) {
                if (z) {
                    a.nA(2);
                } else {
                    a.nA(1);
                }
                a.bwD();
            }
        }
        return false;
    }
}
