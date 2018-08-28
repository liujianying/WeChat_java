package com.tencent.mm.plugin.notification.d;

import com.tencent.mm.g.a.nt;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

class d$3 implements Runnable {
    final /* synthetic */ long bAw;
    final /* synthetic */ bd dAs;
    final /* synthetic */ d lHM;

    d$3(d dVar, long j, bd bdVar) {
        this.lHM = dVar;
        this.bAw = j;
        this.dAs = bdVar;
    }

    public final void run() {
        x.d("MicroMsg.SendNormalMsgFailNotificaiton", "resend msgId:%d", new Object[]{Long.valueOf(this.bAw)});
        nt ntVar = new nt();
        ntVar.bYM.bGS = this.dAs;
        a.sFg.m(ntVar);
    }
}
