package b.c.b;

import b.c.a;
import b.e.b;

public final class c implements b, b<Object> {
    private final Class<?> vGE;

    public c(Class<?> cls) {
        e.i((Object) cls, "jClass");
        this.vGE = cls;
    }

    public final Class<?> cJL() {
        return this.vGE;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof c) && e.i(a.a(this), a.a((b) obj));
    }

    public final int hashCode() {
        return a.a(this).hashCode();
    }

    public final String toString() {
        return this.vGE.toString() + " (Kotlin reflection is not available)";
    }
}
