package com.google.android.gms.c;

import com.google.android.gms.c.ah.c;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class ah$b implements ThreadFactory {
    private static final AtomicInteger aYt = new AtomicInteger();

    private ah$b() {
    }

    /* synthetic */ ah$b(byte b) {
        this();
    }

    public final Thread newThread(Runnable runnable) {
        return new c(runnable, "measurement-" + aYt.incrementAndGet());
    }
}
