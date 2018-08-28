package com.tencent.mm.ipcinvoker;

import android.os.HandlerThread;
import com.tencent.mm.ipcinvoker.a.b;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

class l$a implements b {
    private int dmQ = 3;
    HandlerThread mHandlerThread;

    l$a() {
        HandlerThread handlerThread = new HandlerThread("ThreadPool#InnerWorkerThread-" + hashCode());
        handlerThread.start();
        com.tencent.mm.ipcinvoker.h.b.i("IPC.ExecutorServiceCreatorImpl", "createHandlerThread(hash : %d)", new Object[]{Integer.valueOf(handlerThread.hashCode())});
        this.mHandlerThread = handlerThread;
    }

    public final ExecutorService Cx() {
        ExecutorService anonymousClass2 = new ScheduledThreadPoolExecutor(this.dmQ, new 1(this)) {
            public final void execute(Runnable runnable) {
                super.execute(new 1(this, runnable));
            }
        };
        anonymousClass2.setMaximumPoolSize((int) (((double) this.dmQ) * 1.5d));
        anonymousClass2.setRejectedExecutionHandler(new 3(this));
        return anonymousClass2;
    }
}
