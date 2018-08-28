package com.tencent.mm.plugin.honey_pay;

import com.tencent.mm.g.a.mn;
import com.tencent.mm.plugin.honey_pay.model.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class a$3 extends c<mn> {
    final /* synthetic */ a kjz;

    a$3(a aVar) {
        this.kjz = aVar;
        this.sFo = mn.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mn mnVar = (mn) bVar;
        x.i("MicroMsg.SubCoreHoneyPay", "receive honey pay msg: %s, %s", mnVar.bXv.bXw, Long.valueOf(mnVar.bXv.bXs));
        if (!bi.oW(mnVar.bXv.bXw) && mnVar.bXv.bXs > -1) {
            if (!bi.oW(mnVar.bXv.username)) {
                x.d("MicroMsg.SubCoreHoneyPay", "need replace username: %s", mnVar.bXv.username);
                String x = com.tencent.mm.plugin.honey_pay.model.c.x(mnVar.bXv.bWW, mnVar.bXv.username, 6);
                if (x.equals(mnVar.bXv.bWW)) {
                    mnVar.bXv.bWW = null;
                } else {
                    mnVar.bXv.bWW = x;
                }
            }
            a aVar = new a();
            aVar.field_msgId = mnVar.bXv.bXs;
            aVar.field_payMsgId = mnVar.bXv.bXw;
            this.kjz.aWb().b(aVar);
        }
        return false;
    }
}
