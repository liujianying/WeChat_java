package b;

import b.c.b.e;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class g<T> implements b<T>, Serializable {
    private static final AtomicReferenceFieldUpdater<g<?>, Object> vGx = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "vGv");
    public static final a vGy = new a();
    private volatile b.c.a.a<? extends T> vGu;
    private volatile Object vGv = j.vGz;
    private final Object vGw = j.vGz;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public g(b.c.a.a<? extends T> aVar) {
        e.i((Object) aVar, "initializer");
        this.vGu = aVar;
    }

    public final T getValue() {
        T t = this.vGv;
        if (t != j.vGz) {
            return t;
        }
        b.c.a.a aVar = this.vGu;
        if (aVar != null) {
            t = aVar.invoke();
            if (vGx.compareAndSet(this, j.vGz, t)) {
                this.vGu = null;
                return t;
            }
        }
        return this.vGv;
    }

    public final String toString() {
        return (this.vGv != j.vGz ? 1 : null) != null ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
