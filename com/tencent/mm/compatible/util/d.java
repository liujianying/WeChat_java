package com.tencent.mm.compatible.util;

import android.os.Build.VERSION;

public final class d {
    public static boolean fR(int i) {
        return VERSION.SDK_INT >= i;
    }

    public static boolean fS(int i) {
        return VERSION.SDK_INT < i;
    }

    public static boolean fT(int i) {
        return VERSION.SDK_INT > i;
    }
}
