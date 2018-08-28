package com.tencent.matrix.resource.d.a;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class a<T> {
    public final AtomicReference<T> bsq = new AtomicReference();
    public final CountDownLatch bsr = new CountDownLatch(1);

    public final boolean c(TimeUnit timeUnit) {
        try {
            return this.bsr.await(5, timeUnit);
        } catch (Throwable e) {
            throw new RuntimeException("Did not expect thread to be interrupted", e);
        }
    }
}
