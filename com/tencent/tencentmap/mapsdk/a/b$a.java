package com.tencent.tencentmap.mapsdk.a;

import android.util.SparseArray;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class b$a extends b {
    private ScheduledExecutorService b;
    private SparseArray<ScheduledFuture<?>> c;

    public b$a() {
        this.b = null;
        this.c = null;
        this.b = Executors.newScheduledThreadPool(3);
        this.c = new SparseArray();
    }

    public final synchronized void a(Runnable runnable) {
        if (runnable == null) {
            ct.d("task runner should not be null", new Object[0]);
        } else {
            this.b.execute(runnable);
        }
    }

    public final synchronized void a(int i, Runnable runnable, long j, long j2) {
        long j3 = 0;
        synchronized (this) {
            if (runnable == null) {
                ct.d("task runner should not be null", new Object[0]);
            } else {
                long j4;
                if (j > 0) {
                    j3 = j;
                }
                if (a) {
                    if (j2 <= 10000) {
                        j2 = 10000;
                    }
                    j4 = j2;
                } else {
                    j4 = j2;
                }
                a(i);
                ScheduledFuture scheduleAtFixedRate = this.b.scheduleAtFixedRate(runnable, j3, j4, TimeUnit.MILLISECONDS);
                if (scheduleAtFixedRate != null) {
                    ct.b("add a new future! taskId: %d , periodTime: %d", new Object[]{Integer.valueOf(i), Long.valueOf(j4)});
                    this.c.put(i, scheduleAtFixedRate);
                }
            }
        }
    }

    public final synchronized void a(int i) {
        ScheduledFuture scheduledFuture = (ScheduledFuture) this.c.get(i);
        if (!(scheduledFuture == null || scheduledFuture.isCancelled())) {
            ct.b("cancel a old future!", new Object[0]);
            scheduledFuture.cancel(true);
        }
        this.c.remove(i);
    }

    public final synchronized void a(Runnable runnable, long j) {
        if (runnable == null) {
            ct.d("task runner should not be null", new Object[0]);
        } else {
            if (j <= 0) {
                j = 0;
            }
            this.b.schedule(runnable, j, TimeUnit.MILLISECONDS);
        }
    }
}
