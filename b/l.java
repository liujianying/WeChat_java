package b;

import b.c.a.a;
import b.c.b.e;
import java.io.Serializable;

public final class l<T> implements b<T>, Serializable {
    private a<? extends T> vGu;
    private Object vGv = j.vGz;

    public l(a<? extends T> aVar) {
        e.i(aVar, "initializer");
        this.vGu = aVar;
    }

    public final T getValue() {
        if (this.vGv == j.vGz) {
            a aVar = this.vGu;
            if (aVar == null) {
                e.cJM();
            }
            this.vGv = aVar.invoke();
            this.vGu = null;
        }
        return this.vGv;
    }

    public final String toString() {
        return (this.vGv != j.vGz ? 1 : null) != null ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
