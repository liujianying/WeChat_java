package com.tencent.mm.ab;

import com.tencent.mm.vending.c.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

class w$3 implements a<Void, a.a<T>> {
    final /* synthetic */ AtomicReference dKt;
    final /* synthetic */ CountDownLatch dKv;

    w$3(AtomicReference atomicReference, CountDownLatch countDownLatch) {
        this.dKt = atomicReference;
        this.dKv = countDownLatch;
    }

    public final /* synthetic */ Object call(Object obj) {
        this.dKt.set((a.a) obj);
        this.dKv.countDown();
        return uQG;
    }
}
