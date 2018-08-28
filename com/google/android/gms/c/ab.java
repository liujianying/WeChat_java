package com.google.android.gms.c;

import com.google.android.gms.common.internal.g;
import java.util.regex.Pattern;

public final class ab {
    private static final Pattern aXP = Pattern.compile("\\$\\{(.*?)\\}");

    public static boolean bt(String str) {
        return str == null || g.aNs.k(str);
    }
}
