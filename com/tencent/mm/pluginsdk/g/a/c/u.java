package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.mm.sdk.f.e;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class u implements ThreadFactory {
    private static final AtomicInteger qDD = new AtomicInteger(1);
    private final AtomicInteger dXa;
    private String dXb;

    public u() {
        this("ResDownloaderPool", "ResDownloaderThread");
    }

    public u(String str, String str2) {
        this.dXa = new AtomicInteger(1);
        this.dXb = String.format("%s-%d-%s-", new Object[]{str, Integer.valueOf(qDD.getAndIncrement()), str2});
    }

    public final Thread newThread(Runnable runnable) {
        Thread d = e.d(runnable, this.dXb + this.dXa.getAndIncrement(), 1);
        if (d.isDaemon()) {
            d.setDaemon(false);
        }
        return d;
    }
}
