package com.tencent.mm.plugin.appbrand.h;

import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.plugin.appbrand.h.e.b;
import com.tencent.mm.protocal.c.ait;
import com.tencent.mm.sdk.platformtools.x;

class e$b$2 implements a {
    final /* synthetic */ b gkh;

    e$b$2(b bVar) {
        this.gkh = bVar;
    }

    public final int a(int i, int i2, String str, com.tencent.mm.ab.b bVar, l lVar) {
        ait ait = (ait) bVar.dIE.dIL;
        x.i("MicroMsg.WxaUpdateableMsgService", "getUpdateableMsg errType:%d errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0 && ait.rLu != null && ait.rLu.size() > 0) {
            x.i("MicroMsg.WxaUpdateableMsgService", "getUpdateableMsg response.updatable_msg_list.size:%d", new Object[]{Integer.valueOf(ait.rLu.size())});
            b.a(this.gkh, ait);
            b.b(this.gkh, ait);
            b.a(ait);
            b.b(this.gkh);
        }
        return 0;
    }
}
