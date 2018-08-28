package com.tencent.mm.ak.a.a;

import com.tencent.mm.ak.a.c.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class a$b extends ThreadPoolExecutor implements h {
    private ReentrantLock dXd = new ReentrantLock();
    private Condition dXe = this.dXd.newCondition();
    private BlockingQueue<Runnable> dXf;
    private boolean isPaused;

    public a$b(int i, int i2, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, 0, timeUnit, blockingQueue, threadFactory);
        this.dXf = blockingQueue;
    }

    protected final void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        this.dXd.lock();
        while (this.isPaused) {
            try {
                this.dXe.await();
            } catch (Exception e) {
                thread.interrupt();
                x.w("MicroMsg.imageloader.DefaultThreadPoolExecutor", "[cpan] before execute exception:%s", new Object[]{e.toString()});
            } finally {
                this.dXd.unlock();
            }
        }
    }

    public final void pause() {
        this.dXd.lock();
        try {
            this.isPaused = true;
        } finally {
            this.dXd.unlock();
        }
    }

    public final void resume() {
        this.dXd.lock();
        try {
            this.isPaused = false;
            this.dXe.signalAll();
        } finally {
            this.dXd.unlock();
        }
    }

    public final void execute(Runnable runnable) {
        super.execute(runnable);
    }

    public final boolean wc() {
        return this.isPaused;
    }

    public final void remove(Object obj) {
        if (this.dXf != null) {
            this.dXf.remove(obj);
        }
    }
}
