package com.tencent.tencentmap.mapsdk.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class bv implements ThreadFactory {
    private String a;
    private AtomicInteger b = new AtomicInteger(1);

    public bv(String str) {
        this.a = str;
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.a + "_" + this.b.getAndIncrement());
    }
}
