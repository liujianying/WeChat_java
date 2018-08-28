package com.tencent.mm.ui.conversation;

import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;

class h$2 implements Runnable {
    final /* synthetic */ h uqn;

    h$2(h hVar) {
        this.uqn = hVar;
    }

    public final void run() {
        if (au.HX()) {
            long VF = ai.VF();
            h.d(this.uqn);
            x.d("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", new Object[]{Long.valueOf(ai.bH(VF) * 3), Long.valueOf(h.cyT()), Boolean.valueOf(h.a(this.uqn))});
            h.gN((VF + h.cyT()) / 2);
            h.e(this.uqn);
            al c = h.c(this.uqn);
            long cyT = h.cyT();
            c.J(cyT, cyT);
            return;
        }
        h.c(this.uqn).SO();
        x.e("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange acc has not ready");
    }
}
