package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

import android.content.Intent;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.d.a;
import com.tencent.mm.sdk.platformtools.x;

class c$3 implements a {
    final /* synthetic */ c kMQ;

    c$3(c cVar) {
        this.kMQ = cVar;
    }

    public final void c(int i, Intent intent) {
        if (i == -1) {
            c cVar = this.kMQ;
            if (cVar.kMM == null) {
                x.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.succeed ui == null");
                return;
            }
            cVar.kMM.baB();
            cVar.kMM.b(-1, new Intent());
            return;
        }
        this.kMQ.Q(intent);
    }
}
