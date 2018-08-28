package com.tencent.mm.ak.a.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class a$a implements ThreadFactory {
    private static final AtomicInteger dWY = new AtomicInteger(1);
    private final ThreadGroup dWZ;
    private final AtomicInteger dXa = new AtomicInteger(1);
    private final String dXb;
    private final int dXc;

    a$a(int i, String str) {
        this.dXc = i;
        SecurityManager securityManager = System.getSecurityManager();
        this.dWZ = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.dXb = str + dWY.getAndIncrement() + "-thread-";
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.dWZ, runnable, this.dXb + this.dXa.getAndIncrement(), 0);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        thread.setPriority(this.dXc);
        return thread;
    }
}
