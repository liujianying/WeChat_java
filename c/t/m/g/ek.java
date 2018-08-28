package c.t.m.g;

import java.lang.reflect.Method;

public final class ek {
    public final Class<?> a;
    public final Method b;
    public final Object c;

    public ek(Class<?> cls, Method method, Object obj) {
        this.a = cls;
        this.b = method;
        this.c = obj;
    }
}
