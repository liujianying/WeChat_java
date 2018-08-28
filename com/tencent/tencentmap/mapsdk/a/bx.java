package com.tencent.tencentmap.mapsdk.a;

import com.qq.sim.Millis100TimeProvider;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class bx<K, V> {
    ReentrantReadWriteLock a = new ReentrantReadWriteLock();
    final ExecutorService b = Executors.newFixedThreadPool(2, new bv("TimeoutCacheWorker"));
    ca<K, V> c = new ca();
    private ConcurrentHashMap<K, bz<K, V>> d = null;
    private volatile ScheduledExecutorService e;

    public bx(int i) {
        this.d = new ConcurrentHashMap(i);
        this.e = Executors.newScheduledThreadPool(1, new bv("TimeoutCacheChecker"));
        this.e.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                long currentTimeMillis = Millis100TimeProvider.INSTANCE.currentTimeMillis();
                int a = bx.this.a();
                if (a > 0) {
                    ax.a("cleanSize:" + a + " cost:" + (Millis100TimeProvider.INSTANCE.currentTimeMillis() - currentTimeMillis));
                }
            }
        }, 500, 500, TimeUnit.MILLISECONDS);
    }

    public V a(K k, V v, by<K, V> byVar, long j) {
        bz b = b(new bz(k, v, byVar, Millis100TimeProvider.INSTANCE.currentTimeMillis(), j));
        return b != null ? b.b : null;
    }

    private bz<K, V> b(bz<K, V> bzVar) {
        this.a.writeLock().lock();
        try {
            bz<K, V> bzVar2 = (bz) this.d.put(bzVar.a, bzVar);
            this.c.b(bzVar);
            if (bzVar2 != null) {
                this.c.a(bzVar2);
            }
            this.a.writeLock().unlock();
            return bzVar2;
        } catch (Throwable th) {
            this.a.writeLock().unlock();
        }
    }

    V a(bz<K, V> bzVar) {
        this.a.writeLock().lock();
        try {
            if (((bz) this.d.get(bzVar.a)) == bzVar) {
                this.d.remove(bzVar.a);
                this.c.a(bzVar);
                V v = bzVar.b;
                return v;
            }
            this.a.writeLock().unlock();
            return null;
        } finally {
            this.a.writeLock().unlock();
        }
    }

    public int a() {
        int i = 0;
        try {
            for (Entry value : this.d.entrySet()) {
                int i2;
                bz bzVar = (bz) value.getValue();
                long currentTimeMillis = Millis100TimeProvider.INSTANCE.currentTimeMillis() - bzVar.e;
                if (currentTimeMillis >= bzVar.f) {
                    a(bzVar);
                    this.b.submit(new 2(this, bzVar, currentTimeMillis));
                    i2 = i + 1;
                } else {
                    i2 = i;
                }
                i = i2;
            }
        } catch (Exception e) {
            System.err.print("cleanTimeoutItem error" + e);
        }
        return i;
    }
}
