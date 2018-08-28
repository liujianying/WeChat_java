package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.fr.c;
import java.util.concurrent.CountDownLatch;

class fr$b implements Runnable {
    private CountDownLatch a = null;
    private c b = null;
    private fq c = null;

    public fr$b(CountDownLatch countDownLatch, c cVar, fq fqVar) {
        this.a = countDownLatch;
        this.b = cVar;
        this.c = fqVar;
    }

    public final void run() {
        try {
            this.c.a();
            fr.a = this.c.e();
            fr.b = this.c.f();
            this.b.a(this.c);
            this.a.countDown();
        } catch (Throwable th) {
        }
    }
}
