package com.tencent.mm.plugin.welab;

import com.tencent.mm.ab.d;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.welab.d.b;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements a {
    public final void a(d.a aVar) {
        if (aVar == null || aVar.dIN == null || aVar.dIN.rcl == null) {
            x.i("MicroMsg.WelabNewMsgLsn", "recv null msg");
            return;
        }
        String a = ab.a(aVar.dIN.rcl);
        x.i("MicroMsg.WelabNewMsgLsn", "recv addMsg " + a);
        com.tencent.mm.plugin.welab.c.a.a RV = g.RV(a);
        if (RV != null && RV.isValid()) {
            if (RV.field_status == 1) {
                b.bYI().qmM.a(RV, new String[]{"expId"});
            } else {
                b.bYI().qmM.c(RV);
                b.bYX().f(RV);
                h.mEJ.a((long) RV.field_idkey, (long) RV.field_idkeyValue, 1, false);
            }
            e.n(RV.field_LabsAppId, 6, false);
        }
    }
}
