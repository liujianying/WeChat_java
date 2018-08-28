package c.t.m.g;

import java.util.concurrent.CountDownLatch;

final class aa implements Runnable {
    private /* synthetic */ boolean[] a;
    private /* synthetic */ CountDownLatch b;

    aa(boolean[] zArr, CountDownLatch countDownLatch) {
        this.a = zArr;
        this.b = countDownLatch;
    }

    public final void run() {
        try {
            this.a[0] = z.c();
        } catch (Throwable th) {
            this.a[0] = z.b();
        }
        this.b.countDown();
    }
}
