package com.tinkerboots.sdk.b;

import java.util.HashSet;

public final class c {
    private static String vGl;
    private static HashSet<String> vGm = new HashSet();

    public static String cJE() {
        if (vGl == null) {
            return "";
        }
        return vGl;
    }

    public static boolean cJF() {
        if (vGl == null) {
            return false;
        }
        return vGm.contains(vGl);
    }
}
