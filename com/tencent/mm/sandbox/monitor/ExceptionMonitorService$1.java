package com.tencent.mm.sandbox.monitor;

import com.tencent.mm.sdk.platformtools.x;

class ExceptionMonitorService$1 implements Runnable {
    final /* synthetic */ ExceptionMonitorService sDg;

    ExceptionMonitorService$1(ExceptionMonitorService exceptionMonitorService) {
        this.sDg = exceptionMonitorService;
    }

    public final void run() {
        x.d("MicroMsg.CrashMonitorService", "stopSelf");
        this.sDg.stopSelf();
    }
}
