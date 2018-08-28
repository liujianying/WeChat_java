package com.tencent.mm.ab;

import android.os.Looper;
import com.tencent.mm.ab.a.a;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public final class w {
    public static <T extends bhp> a<T> b(b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("Cant use NULL rr");
        }
        o DG = v.dKi == null ? null : v.dKi.DG();
        if (DG == null) {
            x.e("MicroMsg.SynchronousCgiCall", "NetSceneQueue not ready, just return NULL");
            return null;
        } else if (ah.isMainThread()) {
            throw new IllegalAccessError("Cant call this function in main thread");
        } else if (DG.dJt.lnJ.getLooper().getThread().getId() == Thread.currentThread().getId()) {
            throw new IllegalAccessError("Cant call this function in NetSceneQueue's worker thread!!!");
        } else {
            final AtomicReference atomicReference = new AtomicReference();
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            v.a(bVar, new v.a() {
                public final int a(int i, int i2, String str, b bVar, l lVar) {
                    atomicReference.set(a.a(i, i2, str, (bhp) bVar.dIE.dIL, lVar, null));
                    countDownLatch.countDown();
                    return 0;
                }
            });
            new al(Looper.getMainLooper(), new al.a() {
                public final boolean vD() {
                    atomicReference.set(new a());
                    countDownLatch.countDown();
                    return false;
                }
            }, false).J(20000, 20000);
            try {
                countDownLatch.await();
                return (a) atomicReference.get();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SynchronousCgiCall", e, "latch await exp ", new Object[0]);
                return null;
            }
        }
    }

    public static <T extends bhp> a<T> a(a<T> aVar) {
        o DG = v.dKi == null ? null : v.dKi.DG();
        if (DG == null) {
            x.e("MicroMsg.SynchronousCgiCall", "NetSceneQueue not ready, just return NULL");
            return null;
        } else if (ah.isMainThread()) {
            throw new IllegalAccessError("Cant call this function in main thread");
        } else if (DG.dJt.lnJ.getLooper().getThread().getId() == Thread.currentThread().getId()) {
            throw new IllegalAccessError("Cant call this function in NetSceneQueue's worker thread!!!");
        } else {
            AtomicReference atomicReference = new AtomicReference();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            aVar.KM().f(new 3(atomicReference, countDownLatch));
            try {
                countDownLatch.await();
                return (a) atomicReference.get();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SynchronousCgiCall", e, "semaphore await exp ", new Object[0]);
                return null;
            }
        }
    }
}
