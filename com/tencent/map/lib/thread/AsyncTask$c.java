package com.tencent.map.lib.thread;

import java.util.LinkedList;
import java.util.concurrent.Executor;

class AsyncTask$c implements Executor {
    final LinkedList<Runnable> a;
    Runnable b;

    private AsyncTask$c() {
        this.a = new LinkedList();
    }

    public synchronized void execute(Runnable runnable) {
        this.a.offer(new 1(this, runnable));
        if (this.b == null) {
            a();
        }
    }

    protected synchronized void a() {
        Runnable runnable = (Runnable) this.a.poll();
        this.b = runnable;
        if (runnable != null) {
            AsyncTask.sHighThreadExecutor.execute(this.b);
        }
    }
}
