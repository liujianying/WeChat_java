package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.offline.a.d;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class g$1 implements e {
    final /* synthetic */ g lJa;

    g$1(g gVar) {
        this.lJa = gVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if ((lVar instanceof d) && i == 0 && i2 == 0) {
            d dVar = (d) lVar;
            g.access$002(dVar.lJH);
            if (g.bB() == 0) {
                g.access$002(g.KD());
            }
            x.i(g.ath(), "NetSceneOfflineGetMsg: ackkey: %s, appMsg: %s", new Object[]{dVar.lJI, dVar.lJG});
            if (bi.oW(dVar.lJG) || bi.oW(dVar.lJI)) {
                x.i(g.ath(), "OfflineGetMsgLogic msg is null");
            } else if (g.ec(dVar.lJI, dVar.lJG)) {
                x.i(g.ath(), "from cgi");
                if (bl.z(dVar.lJG, "sysmsg") != null) {
                    h.mEJ.a(135, 71, 1, true);
                    k.bkO();
                    s bkP = k.bkP();
                    String str2 = dVar.lJG;
                    x.i("MicroMsg.WalletOfflineMsgManager", "notifyMsgFromCgi");
                    if (!TextUtils.isEmpty(str2)) {
                        Map z = bl.z(str2, "sysmsg");
                        int i3;
                        if (z != null) {
                            z.get(".sysmsg.paymsg.ack_key");
                            i3 = bi.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
                        } else {
                            i3 = -1;
                        }
                        if (!(!a.bma() || i3 == 7 || i3 == 10)) {
                            x.i("MicroMsg.WalletOfflineMsgManager", "process msg from pull");
                            bkP.IV(str2);
                            bkP.IW(str2);
                        }
                    }
                } else {
                    return;
                }
            }
            x.i(g.ath(), "mIntercal=" + g.bB());
            long bB = (long) g.bB();
            g.a(this.lJa).J(bB, bB);
        }
    }
}
