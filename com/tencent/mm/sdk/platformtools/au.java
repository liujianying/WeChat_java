package com.tencent.mm.sdk.platformtools;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class au {
    private static final ConcurrentLinkedQueue<Runnable> sIq = new ConcurrentLinkedQueue();
    private static ExecutorService sIr = null;

    au() {
    }

    public static ExecutorService ciA() {
        ExecutorService executorService;
        synchronized (au.class) {
            if (sIr == null) {
                sIr = Executors.newSingleThreadExecutor();
            }
            executorService = sIr;
        }
        return executorService;
    }

    public static void O(Runnable runnable) {
        sIq.add(runnable);
    }

    public static void P(Runnable runnable) {
        sIq.remove(runnable);
    }
}
