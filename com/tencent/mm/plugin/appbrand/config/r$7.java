package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.ab.a$a;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.protocal.c.chb;
import com.tencent.mm.protocal.c.gs;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import java.util.Iterator;

class r$7 implements a<Void, a$a<gs>> {
    r$7() {
    }

    public final /* synthetic */ Object call(Object obj) {
        int i = 0;
        a$a a_a = (a$a) obj;
        if (a_a.errType != 0 || a_a.errCode != 0) {
            x.e("MicroMsg.WxaAttrSyncHelper", "BatchBizAttrSync, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(a_a.errType), Integer.valueOf(a_a.errCode), a_a.Yy});
        } else if (a_a.dIv != null) {
            long dO = e.aba().dCZ.dO(Thread.currentThread().getId());
            Iterator it = ((gs) a_a.dIv).rgX.iterator();
            while (it.hasNext()) {
                chb chb = (chb) it.next();
                i = e.aba().a(chb.spJ, chb.riB, chb.riC) | i;
            }
            e.aba().dCZ.gp(dO);
            if (i != 0) {
                q.aei().b("batch", 3, null);
            }
        }
        return uQG;
    }
}
