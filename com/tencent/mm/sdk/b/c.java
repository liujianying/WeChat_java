package com.tencent.mm.sdk.b;

import com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.b.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class c<T extends b> {
    final int priority;
    public int sFo;
    private b<c> sFp;

    public abstract boolean a(T t);

    public c() {
        this(0);
    }

    public c(int i) {
        this.sFo = 0;
        this.priority = i;
    }

    final int chs() {
        if (this.sFo == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            Type genericSuperclass = getClass().getGenericSuperclass();
            if (!(genericSuperclass instanceof ParameterizedType)) {
                genericSuperclass = getClass().getSuperclass().getGenericSuperclass();
            }
            this.sFo = ((Class) ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]).getName().hashCode();
            x.v("IListener", "genEventID, %s<%s>, useTime:%d", getClass().getName(), r1, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        return this.sFo;
    }

    public final synchronized b<c> cht() {
        if (this.sFp == null) {
            ListenerInstanceMonitor.cc(this);
            this.sFp = a.sFg.a(this);
        }
        return this.sFp;
    }

    public final synchronized void dead() {
        if (this.sFp != null) {
            ListenerInstanceMonitor.cd((c) this.sFp.uQB);
            this.sFp.dead();
            this.sFp = null;
        }
    }
}
