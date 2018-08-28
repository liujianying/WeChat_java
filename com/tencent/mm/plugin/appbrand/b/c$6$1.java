package com.tencent.mm.plugin.appbrand.b;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.plugin.appbrand.b.c.6;

class c$6$1 implements IdleHandler {
    final /* synthetic */ 6 fjy;

    c$6$1(6 6) {
        this.fjy = 6;
    }

    public final boolean queueIdle() {
        Looper.myLooper().quit();
        return false;
    }
}
