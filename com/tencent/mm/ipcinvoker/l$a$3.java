package com.tencent.mm.ipcinvoker;

import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.ipcinvoker.l.a;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

class l$a$3 implements RejectedExecutionHandler {
    final /* synthetic */ a dmR;

    l$a$3(a aVar) {
        this.dmR = aVar;
    }

    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        b.w("IPC.ExecutorServiceCreatorImpl", "on rejectedExecution(r : %s)", new Object[]{runnable});
    }
}
