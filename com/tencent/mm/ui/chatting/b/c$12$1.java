package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.ac.e.a.b;
import com.tencent.mm.ac.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.chatting.b.b.m;
import com.tencent.mm.ui.chatting.b.c.12;

class c$12$1 implements Runnable {
    final /* synthetic */ ab eLI;
    final /* synthetic */ b tOp;
    final /* synthetic */ 12 tOq;

    c$12$1(12 12, b bVar, ab abVar) {
        this.tOq = 12;
        this.tOp = bVar;
        this.eLI = abVar;
    }

    public final void run() {
        if (this.tOq.tOm.tOj && this.tOp.dKF.equals(this.tOq.tOm.bAG.getTalkerUserName())) {
            x.i("MicroMsg.ChattingUI.BizComponent", "try to refresh footer.");
            this.tOq.tOm.lUs = f.kH(this.tOp.dKF);
            if (this.tOq.tOm.bAG != null) {
                ((m) this.tOq.tOm.bAG.O(m.class)).Y(this.eLI);
            }
        }
    }
}
