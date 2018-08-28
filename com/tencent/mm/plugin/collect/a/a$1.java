package com.tencent.mm.plugin.collect.a;

import com.tencent.mm.ab.d;
import com.tencent.mm.g.a.bt;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.collect.b.t;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class a$1 implements a {
    final /* synthetic */ a hTG;

    a$1(a aVar) {
        this.hTG = aVar;
    }

    public final void a(d.a aVar) {
        a.aBC();
        if (a.aBD() != null) {
            String a = ab.a(aVar.dIN.rcl);
            a.aBC();
            com.tencent.mm.plugin.collect.b.d aBD = a.aBD();
            long j = (long) aVar.dIN.lOH;
            x.v("MicroMsg.CollectPayerMsgMgr", "func[onResvMsg] content:" + a);
            if (bi.oW(a)) {
                x.d("MicroMsg.CollectPayerMsgMgr", "func[onResvMsg] Msg content empty");
                return;
            }
            Map z = bl.z(a, "sysmsg");
            int i = bi.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), 0);
            if (i == 9 || i == 26) {
                t tVar = new t();
                tVar.username = bi.oV((String) z.get(".sysmsg.paymsg.username"));
                tVar.hUL = bi.getDouble((String) z.get(".sysmsg.paymsg.fee"), 0.0d) / 100.0d;
                tVar.bJg = bi.oV((String) z.get(".sysmsg.paymsg.feetype"));
                tVar.timestamp = bi.getInt((String) z.get(".sysmsg.paymsgtimestamp"), (int) bi.VE());
                tVar.bOe = bi.oV((String) z.get(".sysmsg.paymsg.transid"));
                tVar.daA = bi.oV((String) z.get(".sysmsg.paymsg.displayname"));
                tVar.scene = bi.getInt((String) z.get(".sysmsg.paymsg.scene"), 1);
                tVar.status = bi.getInt((String) z.get(".sysmsg.paymsg.status"), 0);
                tVar.msgType = i;
                tVar.hUM = bi.oV((String) z.get(".sysmsg.paymsg.outtradeno"));
                tVar.type = bi.oV((String) z.get(".sysmsg.paymsg.type"));
                aBD.a(tVar);
                if (tVar.status == 1) {
                    bt btVar = new bt();
                    btVar.bJf.fee = (int) Math.round(tVar.hUL * 100.0d);
                    btVar.bJf.bJg = tVar.bJg;
                    btVar.bJf.bJi = tVar.type;
                    btVar.bJf.bJh = tVar.hUM;
                    btVar.bJf.btC = System.currentTimeMillis() - (j * 1000);
                    btVar.bJf.source = 1;
                    com.tencent.mm.sdk.b.a.sFg.m(btVar);
                    return;
                }
                return;
            }
            x.i("MicroMsg.CollectPayerMsgMgr", "Not ftf collect msg type, ignore; type=" + i);
            return;
        }
        x.w("MicroMsg.SubCoreCollect", "func[onRecieveMsg] payerMsgMgr null");
    }
}
