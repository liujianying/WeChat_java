package com.tencent.mm.pluginsdk.g.a.c;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

public abstract class f<T extends b> {
    final Map<String, b> qCU = new ConcurrentHashMap();
    final Map<String, Future<?>> qCV = new ConcurrentHashMap();

    public abstract d a(T t);

    public abstract a ccv();

    public final void b(T t) {
        this.qCU.put(t.cco(), t);
        ccv().submit(a(t));
    }

    public final synchronized boolean Tl(String str) {
        boolean z;
        z = this.qCV.containsKey(str) || this.qCU.containsKey(str);
        return z;
    }
}
