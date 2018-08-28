package com.tencent.mm.plugin.notification.a;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.notification.a.a.1.1.1;

class a$1$1$1$1 implements Runnable {
    final /* synthetic */ 1 lHq;

    a$1$1$1$1(1 1) {
        this.lHq = 1;
    }

    public final void run() {
        au.getNotification().n(this.lHq.lHn, this.lHq.lHp.lHl);
        if (this.lHq.lHp.lHm.lHk.lHj) {
            this.lHq.lHp.lHm.lHk.lHj = false;
            au.getNotification().aS(false);
        }
    }
}
