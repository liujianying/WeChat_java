package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.aa.j;
import com.tencent.mm.aa.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.e;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bd.a;

public final class d extends e {
    protected final bd a(by byVar, String str, String str2, String str3) {
        String a = ab.a(byVar.rcl);
        if (a == null || a.length() <= 0) {
            x.e("MicroMsg.CardMsgExtension", "possible friend msg : content is null");
            return null;
        }
        a YV = a.YV(a);
        if (byVar.jQd == 66) {
            ((b) g.l(b.class)).oC(YV.tbK);
        }
        if (bi.oV(YV.otZ).length() > 0) {
            j jVar = new j();
            jVar.username = YV.otZ;
            jVar.csA = 3;
            jVar.by(true);
            jVar.dHR = YV.tbG;
            jVar.dHQ = YV.tbH;
            jVar.bWA = -1;
            x.d("MicroMsg.CardMsgExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[]{YV.otZ, jVar.Kx(), jVar.Ky()});
            q.KH().a(jVar);
        }
        return super.a(byVar, str, str2, str3);
    }
}
