package com.tencent.mm.plugin.notification.d;

import com.tencent.mm.g.a.nv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

class e$3 implements Runnable {
    final /* synthetic */ long bAw;
    final /* synthetic */ e lHT;

    e$3(e eVar, long j) {
        this.lHT = eVar;
        this.bAw = j;
    }

    public final void run() {
        x.d("MicroMsg.SendSnsFailNotification", "resend snsInfo id:%d", new Object[]{Long.valueOf(this.bAw)});
        nv nvVar = new nv();
        nvVar.bYQ.bYR = (int) this.bAw;
        a.sFg.m(nvVar);
    }
}
