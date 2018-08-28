package com.google.android.exoplayer2;

import java.util.HashSet;

public final class j {
    private static final HashSet<String> adR = new HashSet();
    private static String adS = "goog.exo.core";

    public static synchronized String iO() {
        String str;
        synchronized (j.class) {
            str = adS;
        }
        return str;
    }

    public static synchronized void ae(String str) {
        synchronized (j.class) {
            if (adR.add(str)) {
                adS += ", " + str;
            }
        }
    }
}
