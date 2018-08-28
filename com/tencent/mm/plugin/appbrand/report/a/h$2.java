package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.plugin.appbrand.report.a.h.a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class h$2 extends ThreadPoolExecutor {
    h$2(TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        super(1, 1, 1000, timeUnit, blockingQueue, threadFactory);
    }

    protected final void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (runnable instanceof a) {
            h.amL().j((a) runnable);
        }
    }
}
