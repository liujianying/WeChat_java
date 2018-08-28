package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.mm.pluginsdk.g.a.c.f.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

protected class f$a extends ThreadPoolExecutor {
    final /* synthetic */ f qCW;

    public f$a(f fVar, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, u uVar) {
        this.qCW = fVar;
        super(i, i2, j, timeUnit, blockingQueue, uVar);
    }

    protected final <V> RunnableFuture<V> newTaskFor(Runnable runnable, V v) {
        if (runnable instanceof f$d) {
            return new c(runnable, v, ((f$d) runnable).qCX);
        }
        return super.newTaskFor(runnable, v);
    }

    protected final void terminated() {
        this.qCW.qCV.clear();
        super.terminated();
    }

    protected final void beforeExecute(Thread thread, Runnable runnable) {
        if (runnable instanceof c) {
            c cVar = (c) runnable;
            if (this.qCW.qCV.containsKey(cVar.qCX.cco())) {
                cVar.cancel(false);
            } else {
                this.qCW.qCV.put(cVar.qCX.cco(), cVar);
                this.qCW.qCU.remove(cVar.qCX.cco());
            }
        } else {
            x.i("MicroMsg.ResDownloader.IOWorker", "r = %s is not RequestFutureTask<?>", new Object[]{runnable.getClass().getSimpleName()});
        }
        super.beforeExecute(thread, runnable);
    }

    protected final void afterExecute(Runnable runnable, Throwable th) {
        if (runnable instanceof c) {
            c cVar = (c) runnable;
            this.qCW.qCV.remove(cVar.qCX.cco());
            this.qCW.qCU.remove(cVar.qCX.cco());
        } else {
            x.i("MicroMsg.ResDownloader.IOWorker", "r = %s is not RequestFutureTask<?>", new Object[]{runnable.getClass().getSimpleName()});
        }
        super.afterExecute(runnable, th);
    }
}
