package com.tencent.mm.plugin.hp.b;

import com.tencent.mm.ab.d;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class h implements a {
    public final void a(d.a aVar) {
        by byVar = aVar.dIN;
        if (byVar.jQd == 10002) {
            String a = ab.a(byVar.rcl);
            if (bi.oW(a)) {
                x.w("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "msg content is null");
                return;
            }
            Map z = bl.z(a, "sysmsg");
            if (z != null && z.size() > 0) {
                a = (String) z.get(".sysmsg.$type");
                if (!bi.oW(a) && a.equalsIgnoreCase("checktinkerupdate")) {
                    int i;
                    int WU = bi.WU((String) z.get(".sysmsg.tinkerboots.ignorenetwork"));
                    String aG = bi.aG((String) z.get(".sysmsg.tinkerboots.xmlkey"), "");
                    x.i("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "ignore:%s md5 %s start checkout tinker update. try to do update.", new Object[]{Integer.valueOf(WU), aG});
                    com.tinkerboots.sdk.a gy = com.tinkerboots.sdk.a.cJC().gy("uin", String.valueOf(((long) com.tencent.mm.kernel.a.Dz()) & 4294967295L));
                    String str = "network";
                    if (ao.isWifi(ad.getContext()) || WU == 1) {
                        i = 3;
                    } else {
                        i = 2;
                    }
                    gy.gy(str, String.valueOf(i));
                    if (!bi.oW(aG)) {
                        com.tinkerboots.sdk.a.cJC().gy("xmlkey", aG);
                    }
                    com.tinkerboots.sdk.a.cJC().na(true);
                }
            }
        }
    }
}
