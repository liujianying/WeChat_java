package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mm.ab.d.a;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.k.4;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class k$4$1 implements Runnable {
    final /* synthetic */ a dAr;
    final /* synthetic */ String fhM;
    final /* synthetic */ 4 lJC;

    k$4$1(4 4, String str, a aVar) {
        this.lJC = 4;
        this.fhM = str;
        this.dAr = aVar;
    }

    public final void run() {
        s bkP = k.bkP();
        String str = this.fhM;
        long j = this.dAr.dIN.rcq;
        x.i("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is :" + j);
        x.i("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg content is :" + str);
        if (!TextUtils.isEmpty(str)) {
            if (bkP.el(j)) {
                x.e("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is exist in list:" + j);
                return;
            }
            int i;
            String str2 = null;
            Map z = bl.z(str, "sysmsg");
            if (z != null) {
                str2 = (String) z.get(".sysmsg.paymsg.ack_key");
                i = bi.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
            } else {
                i = -1;
            }
            if (com.tencent.mm.plugin.offline.c.a.bma()) {
                x.i("MicroMsg.WalletOfflineMsgManager", "pos is enabled. PayMsgType is %d", new Object[]{Integer.valueOf(i)});
                if (i == 7 || i == 10) {
                    bkP.IV(str);
                    bkP.IW(str);
                } else if (g.ec(str2, str)) {
                    x.i("MicroMsg.WalletOfflineMsgManager", "process msg from push");
                    h.mEJ.a(135, 70, 1, true);
                    bkP.IV(str);
                    bkP.IW(str);
                }
            } else {
                g.ec(str2, str);
                bkP.IV(str);
                bkP.IW(str);
            }
            if (bkP.lHE.size() > 10) {
                bkP.lHE.remove(bkP.lHE.size() - 1);
            }
            bkP.lHE.add(0, Long.valueOf(j));
        }
    }
}
