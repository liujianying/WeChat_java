package com.tencent.map.lib.thread;

import java.io.Serializable;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class HighThreadExecutor$a<E> extends AbstractQueue<E> implements Serializable, BlockingQueue<E> {
    transient b<E> a;
    final /* synthetic */ HighThreadExecutor b;
    private int c;
    private final AtomicInteger d = new AtomicInteger();
    private final ReentrantLock e = new ReentrantLock();
    private final Condition f = this.e.newCondition();
    private final ReentrantLock g = new ReentrantLock();
    private final Condition h = this.g.newCondition();

    class b<E> {
        E a;
        b<E> b;

        b(E e) {
            this.a = e;
        }
    }

    public HighThreadExecutor$a(HighThreadExecutor highThreadExecutor, int i) {
        this.b = highThreadExecutor;
        this.c = i;
        this.a = new b(null);
    }

    public Iterator<E> iterator() {
        return new a(this);
    }

    public int size() {
        return this.d.get();
    }

    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    public int drainTo(Collection<? super E> collection, int i) {
        ReentrantLock reentrantLock;
        int i2;
        Throwable th;
        int i3 = 1;
        if (collection == null) {
            throw new NullPointerException();
        } else if (collection == this) {
            throw new IllegalArgumentException();
        } else if (i <= 0) {
            return 0;
        } else {
            reentrantLock = this.e;
            reentrantLock.lock();
            b bVar;
            try {
                int min = Math.min(i, this.d.get());
                bVar = this.a;
                i2 = 0;
                while (i2 < min) {
                    b bVar2 = bVar.b;
                    collection.add(bVar2.a);
                    bVar2.a = null;
                    bVar.b = bVar;
                    i2++;
                    bVar = bVar2;
                }
                if (i2 > 0) {
                    this.a = bVar;
                    if (this.d.getAndAdd(-i2) != this.c) {
                        i3 = 0;
                    }
                } else {
                    i3 = 0;
                }
                reentrantLock.unlock();
                if (i3 != 0) {
                    d();
                }
                return min;
            } catch (Throwable th2) {
                th = th2;
                i2 = i3;
            }
        }
        reentrantLock.unlock();
        if (i2 != 0) {
            d();
        }
        throw th;
    }

    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        AtomicInteger atomicInteger = this.d;
        if (atomicInteger.get() == this.c) {
            return false;
        }
        int i = -1;
        b bVar = new b(e);
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            if (atomicInteger.get() < this.c) {
                a(bVar);
                i = atomicInteger.getAndIncrement();
                if (i + 1 < this.c) {
                    this.h.signal();
                }
            }
            reentrantLock.unlock();
            if (i == 0) {
                e();
            }
            if (i >= 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            reentrantLock.unlock();
        }
    }

    public boolean offer(E e, long j, TimeUnit timeUnit) {
        if (e == null) {
            throw new NullPointerException();
        }
        long toNanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.g;
        AtomicInteger atomicInteger = this.d;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == this.c) {
            try {
                if (toNanos <= 0) {
                    return false;
                }
                toNanos = this.h.awaitNanos(toNanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        a(new b(e));
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement + 1 < this.c) {
            this.h.signal();
        }
        reentrantLock.unlock();
        if (andIncrement == 0) {
            e();
        }
        return true;
    }

    public E poll(long j, TimeUnit timeUnit) {
        long toNanos = timeUnit.toNanos(j);
        AtomicInteger atomicInteger = this.d;
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == 0) {
            try {
                if (toNanos <= 0) {
                    return null;
                }
                toNanos = this.f.awaitNanos(toNanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        E b = b();
        int andDecrement = atomicInteger.getAndDecrement();
        if (andDecrement > 1) {
            this.f.signal();
        }
        reentrantLock.unlock();
        if (andDecrement != this.c) {
            return b;
        }
        d();
        return b;
    }

    public void put(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        b bVar = new b(e);
        ReentrantLock reentrantLock = this.g;
        AtomicInteger atomicInteger = this.d;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == this.c) {
            try {
                this.h.await();
            } catch (Throwable th) {
                reentrantLock.unlock();
            }
        }
        a(bVar);
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement + 1 < this.c) {
            this.h.signal();
        }
        reentrantLock.unlock();
        if (andIncrement == 0) {
            e();
        }
    }

    public int remainingCapacity() {
        return this.c - this.d.get();
    }

    public E take() {
        AtomicInteger atomicInteger = this.d;
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == 0) {
            try {
                this.f.await();
            } catch (Throwable th) {
                reentrantLock.unlock();
            }
        }
        E b = b();
        int andDecrement = atomicInteger.getAndDecrement();
        if (andDecrement > 1) {
            this.f.signal();
        }
        reentrantLock.unlock();
        if (andDecrement == this.c) {
            d();
        }
        return b;
    }

    public E peek() {
        E e = null;
        if (this.d.get() != 0) {
            ReentrantLock reentrantLock = this.e;
            reentrantLock.lock();
            try {
                b bVar = this.a.b;
                if (bVar != null) {
                    e = bVar.a;
                    reentrantLock.unlock();
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        return e;
    }

    public E poll() {
        E e = null;
        AtomicInteger atomicInteger = this.d;
        if (atomicInteger.get() != 0) {
            int i = -1;
            ReentrantLock reentrantLock = this.e;
            reentrantLock.lock();
            try {
                if (atomicInteger.get() > 0) {
                    e = b();
                    i = atomicInteger.getAndDecrement();
                    if (i > 1) {
                        this.f.signal();
                    }
                }
                reentrantLock.unlock();
                if (i == this.c) {
                    d();
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
            }
        }
        return e;
    }

    private void a(b<E> bVar) {
        bVar.b = this.a.b;
        this.a.b = bVar;
    }

    private E b() {
        b bVar = this.a.b;
        if (bVar == null) {
            return null;
        }
        this.a.b = bVar.b;
        bVar.b = null;
        E e = bVar.a;
        bVar.a = null;
        return e;
    }

    private void c() {
        this.g.lock();
        this.e.lock();
    }

    void a() {
        this.e.unlock();
        this.g.unlock();
    }

    void a(b<E> bVar, b<E> bVar2) {
        bVar.a = null;
        bVar2.b = bVar.b;
        if (this.d.getAndDecrement() == this.c) {
            this.h.signal();
        }
    }

    private void d() {
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            this.h.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    private void e() {
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            this.f.signal();
        } finally {
            reentrantLock.unlock();
        }
    }
}
