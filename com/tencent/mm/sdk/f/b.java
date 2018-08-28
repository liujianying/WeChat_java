package com.tencent.mm.sdk.f;

import java.util.concurrent.atomic.AtomicInteger;
import junit.framework.Assert;

final class b {
    private ThreadGroup dWZ;
    private final AtomicInteger sKP = new AtomicInteger(1);
    private com.tencent.mm.sdk.f.e.b sKQ;

    static class a extends Thread {
        private g sKR;

        a(ThreadGroup threadGroup, g gVar, String str) {
            super(threadGroup, gVar, str);
            this.sKR = gVar;
        }

        public final void start() {
            super.start();
        }

        public final void run() {
            super.run();
        }
    }

    b(com.tencent.mm.sdk.f.e.b bVar) {
        this.sKQ = bVar;
        this.dWZ = new ThreadGroup("MM_FREE_THREAD_GROUP");
    }

    final Thread a(Runnable runnable, String str, int i) {
        Assert.assertNotNull("newThread arg name is null!", str);
        if (runnable != null) {
            Thread aVar = new a(this.dWZ, new g(runnable, str, i, false, this.sKQ), "mmt_f" + str);
            aVar.setPriority(i);
            return aVar;
        }
        Thread aVar2 = new a(this.dWZ, null, "mmt_f" + str);
        aVar2.setPriority(i);
        return aVar2;
    }
}
