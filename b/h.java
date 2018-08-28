package b;

import b.c.a.a;
import b.c.b.e;
import java.io.Serializable;

public final class h<T> implements b<T>, Serializable {
    private final Object lock;
    private a<? extends T> vGu;
    private volatile Object vGv;

    private h(a<? extends T> aVar) {
        e.i(aVar, "initializer");
        this.vGu = aVar;
        this.vGv = j.vGz;
        this.lock = this;
    }

    public /* synthetic */ h(a aVar, byte b) {
        this(aVar);
    }

    public final T getValue() {
        T t = this.vGv;
        if (t == j.vGz) {
            synchronized (this.lock) {
                t = this.vGv;
                if (t == j.vGz) {
                    a aVar = this.vGu;
                    if (aVar == null) {
                        e.cJM();
                    }
                    t = aVar.invoke();
                    this.vGv = t;
                    this.vGu = null;
                }
            }
        }
        return t;
    }

    public final String toString() {
        return (this.vGv != j.vGz ? 1 : null) != null ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
