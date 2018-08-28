package com.tencent.mm.plugin.appbrand;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;

class g$19 implements IdleHandler {
    final /* synthetic */ g fdd;
    final /* synthetic */ Runnable fdm;

    g$19(g gVar, Runnable runnable) {
        this.fdd = gVar;
        this.fdm = runnable;
    }

    public final boolean queueIdle() {
        Looper.myQueue().removeIdleHandler(this);
        this.fdm.run();
        return false;
    }
}
