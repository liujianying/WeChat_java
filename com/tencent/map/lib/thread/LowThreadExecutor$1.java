package com.tencent.map.lib.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class LowThreadExecutor$1 implements ThreadFactory {
    final /* synthetic */ LowThreadExecutor a;
    private final AtomicInteger b = new AtomicInteger(1);

    LowThreadExecutor$1(LowThreadExecutor lowThreadExecutor) {
        this.a = lowThreadExecutor;
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AsyncTask Low #" + this.b.getAndIncrement());
    }
}
