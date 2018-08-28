package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.mm.pluginsdk.g.a.c.f.b;
import java.util.concurrent.FutureTask;

protected class f$c<V> extends FutureTask<V> {
    protected final b qCX;

    public f$c(Runnable runnable, V v, b bVar) {
        super(runnable, v);
        this.qCX = bVar;
    }
}
