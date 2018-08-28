package com.tencent.mm.ui.conversation;

import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;

class d$2 implements Runnable {
    final /* synthetic */ d uom;

    d$2(d dVar) {
        this.uom = dVar;
    }

    public final void run() {
        if (au.HX()) {
            long VF = ai.VF();
            d.g(this.uom);
            x.d("MicroMsg.ConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", new Object[]{Long.valueOf(ai.bH(VF) * 3), Long.valueOf(d.cyJ()), Boolean.valueOf(d.d(this.uom))});
            d.gM((VF + d.cyJ()) / 2);
            d.h(this.uom);
            al f = d.f(this.uom);
            long cyJ = d.cyJ();
            f.J(cyJ, cyJ);
            return;
        }
        d.f(this.uom).SO();
        x.e("MicroMsg.ConversationAdapter", "dkpno handleDataChange acc has not ready");
    }
}
