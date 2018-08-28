package com.tencent.map.lib.thread;

import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;

public class HighThreadExecutor implements Executor {
    private final ThreadFactory a = new 1(this);
    private final BlockingQueue<Runnable> b = new a(this, 5);
    private final Executor c = new ThreadPoolExecutor(5, MapRouteSectionWithName.kMaxRoadNameLength, 1, TimeUnit.SECONDS, this.b, this.a, new DiscardOldestPolicy());

    public void execute(Runnable runnable) {
        this.c.execute(runnable);
    }
}
