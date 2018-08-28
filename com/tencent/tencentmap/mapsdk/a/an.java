package com.tencent.tencentmap.mapsdk.a;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class an {
    static final /* synthetic */ boolean j = (!an.class.desiredAssertionStatus());
    AtomicInteger a = new AtomicInteger();
    AtomicInteger b = new AtomicInteger();
    AtomicInteger c = new AtomicInteger();
    AtomicLong d = new AtomicLong();
    AtomicInteger e = new AtomicInteger();
    AtomicInteger f = new AtomicInteger();
    public ConcurrentHashMap<Integer, AtomicInteger> g = new ConcurrentHashMap();
    ReentrantReadWriteLock h = new ReentrantReadWriteLock();
    CopyOnWriteArrayList<Integer> i = new CopyOnWriteArrayList();

    public an(List<Integer> list) {
        a(list);
    }

    public void a(List<Integer> list) {
        this.i.clear();
        this.i.addAll(list);
        Iterator it = this.i.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (!this.g.containsKey(num)) {
                this.g.put(num, new AtomicInteger());
            }
        }
    }

    public void a(long j, int i) {
        if (i == 0) {
            this.a.incrementAndGet();
            this.d.addAndGet(j);
            if (((long) this.e.get()) < j) {
                this.e.set((int) j);
            } else if (j > 0 && j < ((long) this.f.get())) {
                this.f.set((int) j);
            }
        } else if (i == 1) {
            this.b.incrementAndGet();
        } else if (i == 2) {
            this.c.incrementAndGet();
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.i.size()) {
                return;
            }
            if (j <= ((long) ((Integer) this.i.get(i3)).intValue())) {
                ((AtomicInteger) this.g.get(this.i.get(i3))).incrementAndGet();
                return;
            }
            i2 = i3 + 1;
        }
    }

    public Object clone() {
        Object obj = null;
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (j) {
                return obj;
            }
            throw new AssertionError();
        }
    }
}
