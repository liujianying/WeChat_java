package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.sdk.f.e;
import java.util.concurrent.ThreadFactory;

class h$1 implements ThreadFactory {
    h$1() {
    }

    public final Thread newThread(Runnable runnable) {
        Thread d = e.d(runnable, "AppBrandJsApiInvokeReportWorkerThread", 1);
        if (d.isDaemon()) {
            d.setDaemon(false);
        }
        return d;
    }
}
