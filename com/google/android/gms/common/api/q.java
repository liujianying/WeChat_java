package com.google.android.gms.common.api;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class q {
    private static final ExecutorService aLL = Executors.newFixedThreadPool(2);

    public static ExecutorService oT() {
        return aLL;
    }
}
