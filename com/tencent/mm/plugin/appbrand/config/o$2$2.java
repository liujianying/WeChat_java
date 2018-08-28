package com.tencent.mm.plugin.appbrand.config;

import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.plugin.appbrand.config.o.2;

class o$2$2 implements IdleHandler {
    final /* synthetic */ 2 frE;

    o$2$2(2 2) {
        this.frE = 2;
    }

    public final boolean queueIdle() {
        this.frE.frD.lnJ.quit();
        return false;
    }
}
