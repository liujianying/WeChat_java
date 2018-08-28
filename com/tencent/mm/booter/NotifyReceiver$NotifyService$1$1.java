package com.tencent.mm.booter;

import com.tencent.mm.booter.NotifyReceiver.NotifyService.1;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.x;

class NotifyReceiver$NotifyService$1$1 implements Runnable {
    final /* synthetic */ 1 cXk;

    NotifyReceiver$NotifyService$1$1(1 1) {
        this.cXk = 1;
    }

    public final void run() {
        x.i("MicroMsg.NotifyReceiver", "summerboot startupDone do delay notify task");
        this.cXk.cXj.m(this.cXk.cXi);
        f.mDy.a(99, 215, 1, false);
    }
}
