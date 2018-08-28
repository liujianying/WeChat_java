package com.tencent.mm.plugin.appbrand.g.a;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Locker;
import com.tencent.xweb.d;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class h {
    public volatile boolean Sx = true;
    public volatile boolean fcO = false;
    public V8 gek;
    public Thread gev;
    final ConcurrentLinkedQueue<Runnable> gew = new ConcurrentLinkedQueue();
    d gex;

    public h(V8 v8) {
        this.gek = v8;
        this.gev = new 1(this);
        V8Locker locker = this.gek.getLocker();
        if (locker.hasLock()) {
            locker.release();
        }
        this.gev.start();
    }

    public final void r(Runnable runnable) {
        this.gew.offer(runnable);
        this.gev.interrupt();
    }
}
