package com.tencent.mm.app;

import java.util.HashSet;
import java.util.Set;

public final class n {
    private static final Set<String> bzc;

    static {
        Set hashSet = new HashSet();
        bzc = hashSet;
        hashSet.add(":nospace");
        bzc.add(":cuploader");
        bzc.add(":dexopt");
        bzc.add(":recovery");
        bzc.add(":fallback");
    }

    public static boolean cP(String str) {
        int indexOf = str.indexOf(58);
        return bzc.contains(indexOf != -1 ? str.substring(indexOf) : "");
    }

    public static boolean vd() {
        return false;
    }
}
