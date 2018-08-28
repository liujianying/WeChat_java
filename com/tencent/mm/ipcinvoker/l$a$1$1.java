package com.tencent.mm.ipcinvoker;

import android.os.Looper;
import com.tencent.mm.ipcinvoker.g.a;
import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.ipcinvoker.l.a.1;

class l$a$1$1 implements Runnable {
    final /* synthetic */ Runnable dmS;
    final /* synthetic */ 1 dmT;

    l$a$1$1(1 1, Runnable runnable) {
        this.dmT = 1;
        this.dmS = runnable;
    }

    public final void run() {
        ThreadLocal threadLocal = (ThreadLocal) new a(Looper.class, "sThreadLocal").CA();
        if (threadLocal == null || threadLocal.get() != null) {
            b.d("IPC.ExecutorServiceCreatorImpl", "ThreadLocal Looper variable is null or has set.(%s)", threadLocal);
        } else {
            b.d("IPC.ExecutorServiceCreatorImpl", "create a new Looper ThreadLocal variable.", new Object[0]);
            threadLocal.set(this.dmT.dmR.mHandlerThread.getLooper());
        }
        this.dmS.run();
    }
}
