package com.tencent.map.lib.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class HighThreadExecutor$1 implements ThreadFactory {
    final /* synthetic */ HighThreadExecutor a;
    private final AtomicInteger b = new AtomicInteger(1);

    HighThreadExecutor$1(HighThreadExecutor highThreadExecutor) {
        this.a = highThreadExecutor;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "AsyncTask High #" + this.b.getAndIncrement());
        thread.setPriority(6);
        return thread;
    }
}
