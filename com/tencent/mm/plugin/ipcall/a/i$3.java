package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.ab.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.ipcall.a.d.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class i$3 implements a {
    final /* synthetic */ i kpj;

    i$3(i iVar) {
        this.kpj = iVar;
    }

    public final void a(d.a aVar) {
        x.i("MicroMsg.SubCoreIPCall", "WCONotify onRecieveMsg");
        String a = ab.a(aVar.dIN.rcl);
        if (a == null || a.length() == 0) {
            x.e("MicroMsg.SubCoreIPCall", "WCONotify onReceiveMsg, msgContent is null");
            return;
        }
        Map z = bl.z(a, "sysmsg");
        if (z == null) {
            x.e("MicroMsg.SubCoreIPCall", "WCONotify onReceiveMsg, values is null");
        } else if (z.containsKey(".sysmsg.WCONotify.NotifyGetBalance")) {
            x.i("MicroMsg.SubCoreIPCall", "WCONotify NotifyGetBalance: %d", new Object[]{Integer.valueOf(bi.getInt((String) z.get(".sysmsg.WCONotify.NotifyGetBalance"), 0))});
            if (bi.getInt((String) z.get(".sysmsg.WCONotify.NotifyGetBalance"), 0) > 0) {
                au.DF().a(new g(2), 0);
            }
        }
    }
}
