package com.tencent.mm.booter;

import com.tencent.mm.booter.NotifyReceiver.NotifyService;

class NotifyReceiver$NotifyService$2 implements Runnable {
    final /* synthetic */ NotifyService cXj;

    NotifyReceiver$NotifyService$2(NotifyService notifyService) {
        this.cXj = notifyService;
    }

    public final void run() {
        this.cXj.stopForeground(true);
    }
}
