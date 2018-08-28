package com.tencent.map.lib.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;

public class LowThreadExecutor implements Executor {
    private final ThreadFactory a = new 1(this);
    private final BlockingQueue<Runnable> b = new LinkedBlockingQueue(20);
    public final Executor mExecutor = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, this.b, this.a, new DiscardOldestPolicy());

    public void execute(Runnable runnable) {
        this.mExecutor.execute(runnable);
    }
}
