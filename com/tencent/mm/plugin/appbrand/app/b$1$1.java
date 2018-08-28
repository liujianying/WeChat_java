package com.tencent.mm.plugin.appbrand.app;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.plugin.appbrand.app.b.1;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.sdk.platformtools.x;

class b$1$1 implements IdleHandler {
    final /* synthetic */ 1 fes;

    b$1$1(1 1) {
        this.fes = 1;
    }

    public final boolean queueIdle() {
        Looper.myQueue().removeIdleHandler(this);
        if (!b.yT()) {
            x.i("MicroMsg.AppBrandProcessProfileInit[applaunch]", "start misc preload");
            AppBrandMainProcessService.ahr();
            d.a(null, false);
        }
        return false;
    }
}
