package com.tencent.matrix.iocanary.b;

import com.tencent.matrix.d.b;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

public final class a {
    private static volatile Object bra;
    public volatile boolean bqZ;
    private final com.tencent.matrix.c.c.a brb;

    public a(com.tencent.matrix.c.c.a aVar) {
        this.brb = aVar;
    }

    public final boolean tu() {
        try {
            Class cls = Class.forName("dalvik.system.CloseGuard");
            Class cls2 = Class.forName("dalvik.system.CloseGuard$Reporter");
            Field declaredField = cls.getDeclaredField("REPORTER");
            Field declaredField2 = cls.getDeclaredField("ENABLED");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            bra = declaredField.get(null);
            declaredField2.set(null, Boolean.valueOf(true));
            c.setEnabled(true);
            ClassLoader classLoader = cls2.getClassLoader();
            if (classLoader == null) {
                return false;
            }
            declaredField.set(null, Proxy.newProxyInstance(classLoader, new Class[]{cls2}, new b(this.brb, bra)));
            declaredField.setAccessible(false);
            return true;
        } catch (Throwable th) {
            b.e("Matrix.CloseGuardHooker", "tryHook exp=%s", th);
            return false;
        }
    }

    public static boolean tv() {
        try {
            Class cls = Class.forName("dalvik.system.CloseGuard");
            Field declaredField = cls.getDeclaredField("REPORTER");
            declaredField.setAccessible(true);
            declaredField.set(null, bra);
            Field declaredField2 = cls.getDeclaredField("ENABLED");
            declaredField2.setAccessible(true);
            declaredField2.set(null, Boolean.valueOf(false));
            declaredField.setAccessible(false);
            c.setEnabled(false);
            return true;
        } catch (Throwable th) {
            b.e("Matrix.CloseGuardHooker", "tryHook exp=%s", th);
            return false;
        }
    }
}
