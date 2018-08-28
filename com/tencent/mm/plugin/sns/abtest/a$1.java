package com.tencent.mm.plugin.sns.abtest;

import com.tencent.mm.g.a.pv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class a$1 extends c<pv> {
    a$1() {
        this.sFo = pv.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        pv pvVar = (pv) bVar;
        if (pvVar instanceof pv) {
            boolean z = pvVar.caA.caB;
            long j = pvVar.caA.bPm;
            x.d("MicroMsg.NotInteresetABTestManager", "blockUserEventListener callback, isBlock:%b, snsInfoSvrId:%b", new Object[]{Boolean.valueOf(z), Long.valueOf(j)});
            if (!(j == 0 || a.ty() == 0 || a.ty() != j)) {
                if (z) {
                    a.nA(4);
                } else {
                    a.nA(3);
                }
                a.bwD();
            }
        }
        return false;
    }
}
