package com.tencent.mm.plugin.appbrand.game.e;

import android.support.v4.e.i.a;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class f<T> implements a<T> {
    public ConcurrentLinkedQueue<T> fDo = new ConcurrentLinkedQueue();

    public abstract T agm();

    public T bW() {
        T poll = this.fDo.poll();
        if (poll == null) {
            return agm();
        }
        return poll;
    }

    public final boolean j(T t) {
        return this.fDo.offer(t);
    }
}
