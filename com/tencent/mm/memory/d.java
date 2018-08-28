package com.tencent.mm.memory;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class d<T, S> {
    protected Queue<T> duU = new ConcurrentLinkedQueue();
    protected S duV;

    public d(S s) {
        this.duV = s;
    }

    public final T pop() {
        return this.duU.poll();
    }

    public final void put(T t) {
        this.duU.add(t);
    }

    public final int size() {
        return this.duU.size();
    }

    public final S Fn() {
        return this.duV;
    }
}
