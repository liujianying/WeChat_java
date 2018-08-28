package com.tencent.mm.plugin.emoji.sync;

import com.tencent.mm.ak.a.c.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class b$b extends ThreadPoolExecutor implements h {
    private ReentrantLock dXd = new ReentrantLock();
    private Condition dXe = this.dXd.newCondition();
    private boolean isPaused;

    public b$b(int i, int i2, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, 0, timeUnit, blockingQueue, threadFactory);
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
    }
}
