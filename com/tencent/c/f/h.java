package com.tencent.c.f;

public final class h {
    private static boolean vkL;
    private static g vkM;

    static {
        vkL = false;
        vkM = new k();
        vkL = false;
        vkM = new k();
    }

    public static void k(Throwable th) {
        cD(th);
    }

    public static void cD(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Exception) {
            new StringBuilder().append(obj);
        } else {
            obj.toString();
        }
    }

    public static void cE(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Exception) {
            new StringBuilder().append(obj);
        } else {
            obj.toString();
        }
    }

    public static void i(String str) {
        cF(str);
    }

    public static void d(String str) {
        cF(str);
    }

    public static void cF(Object obj) {
        if (obj != null) {
            obj.toString();
        }
    }
}
