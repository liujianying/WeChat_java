package org.b.g;

import java.util.regex.Pattern;

public final class d {
    private static final Pattern vKY = Pattern.compile("^[a-zA-Z][a-zA-Z0-9+.-]*://\\S+");

    public static void j(Object obj, String str) {
        r(obj != null, str);
    }

    public static void gE(String str, String str2) {
        boolean z = (str == null || str.trim().equals("")) ? false : true;
        r(z, str2);
    }

    private static void r(boolean z, String str) {
        if (str == null || str.trim().length() <= 0) {
            str = "Received an invalid parameter";
        }
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }
}
