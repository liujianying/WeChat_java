package b.c.b;

import b.a;
import b.k;
import java.util.Arrays;
import java.util.List;

public class e {
    private e() {
    }

    public static void cJM() {
        throw ((a) l(new a()));
    }

    public static void adK(String str) {
        throw ((k) l(new k("lateinit property " + str + " has not been initialized")));
    }

    public static void h(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) l(new IllegalStateException(str + " must not be null")));
        }
    }

    public static void i(Object obj, String str) {
        if (obj == null) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            String className = stackTraceElement.getClassName();
            throw ((IllegalArgumentException) l(new IllegalArgumentException("Parameter specified as non-null is null: method " + className + "." + stackTraceElement.getMethodName() + ", parameter " + str)));
        }
    }

    public static boolean i(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        } else {
            return obj.equals(obj2);
        }
    }

    private static <T extends Throwable> T l(T t) {
        return b(t, e.class.getName());
    }

    static <T extends Throwable> T b(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        List subList = Arrays.asList(stackTrace).subList(i + 1, length);
        t.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
        return t;
    }
}
