package com.tencent.mm.plugin.appbrand.collector;

import java.util.HashSet;
import java.util.Set;

public final class c {
    private static b foc = new h();
    private static boolean fod;
    private static final Set<String> foe = new HashSet();

    public static void ry(String str) {
        if (str.length() != 0) {
            foe.add(str);
        }
    }

    public static void rz(String str) {
        if (str.length() != 0) {
            foe.remove(str);
        }
    }

    public static boolean rA(String str) {
        if (str.length() == 0) {
            return false;
        }
        return foe.contains(str);
    }

    public static void cx(boolean z) {
        fod = z;
    }

    public static boolean adr() {
        return fod;
    }

    private static boolean rB(String str) {
        return fod && foe.contains(str);
    }

    private static boolean rC(String str) {
        if (!fod) {
            return false;
        }
        CollectSession rv = foc.rv(str);
        if (rv == null || !foe.contains(rv.groupId)) {
            return false;
        }
        return true;
    }

    public static void clear() {
        if (fod) {
            foc.clear();
        }
    }

    public static void c(String str, String str2, String str3, boolean z) {
        if (rB(str)) {
            foc.c(str, str2, str3, z);
        }
    }

    public static void ba(String str, String str2) {
        if (rC(str)) {
            foc.ba(str, str2);
        }
    }

    public static void a(CollectSession collectSession) {
        if (collectSession != null && rB(collectSession.groupId)) {
            foc.a(collectSession);
        }
    }

    public static CollectSession aZ(String str, String str2) {
        if (rC(str)) {
            return foc.aZ(str, str2);
        }
        return null;
    }

    public static void c(String str, String str2, boolean z) {
        if (rC(str)) {
            foc.c(str, str2, z);
        }
    }

    public static CollectSession rv(String str) {
        if (rC(str)) {
            return foc.rv(str);
        }
        return null;
    }

    public static CollectSession rw(String str) {
        if (fod) {
            return foc.rw(str);
        }
        return null;
    }

    public static void print(String str) {
        if (rC(str)) {
            foc.print(str);
        }
    }

    public static int bb(String str, String str2) {
        if (rB(str)) {
            return foc.bb(str, str2);
        }
        return 0;
    }

    public static StringBuilder rx(String str) {
        if (rB(str)) {
            return foc.rx(str);
        }
        return new StringBuilder();
    }
}
